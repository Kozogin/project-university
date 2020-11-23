package ua.lviv.lgs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.domain.Point;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.ApplicantService;
import ua.lviv.lgs.service.ComparatorApplicant;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.LessonDTO;
import ua.lviv.lgs.service.PointService;
import ua.lviv.lgs.service.UserDTOHelper;
import ua.lviv.lgs.service.UserService;

@Controller
public class UserController {

	private Faculty choiseFaculty = new Faculty();
	private List<FacultyLessons> lessonThisFaculty = new ArrayList<>();

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private FacultyLessonsService facultyLessonsService;

	@Autowired
	private PointService pointService;

	@Autowired
	private ApplicantService applicantService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam MultipartFile imgFile, @RequestParam String password,
			@RequestParam String passwordConfirm, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) throws IOException {

		userService.save(UserDTOHelper.createEntity(imgFile, password, passwordConfirm, firstName, lastName, email));

		return new ModelAndView("redirect:/reg_succeess");
	}

	@RequestMapping(value = "/reg_succeess", method = RequestMethod.GET)
	public ModelAndView regSucceess() {

		User lastUser = userService.getLastRegistrationUser();

		if (lastUser.getAssignedId() == "") {
			return new ModelAndView("login");
		}

		ModelAndView map = new ModelAndView("reg_succeess");
		map.addObject("lastUser", lastUser);
		return map;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String welcomeAdmin(Model model) {
		return "admin";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model, Authentication authentication) {

		String role = authentication.getAuthorities().stream().findFirst().orElse(null).toString();
		User user = userService.findByAssignedId(authentication.getName()).get();

		if (role.equals("ROLE_ADMIN")) {
			ModelAndView map = new ModelAndView("admin");
			map.addObject("users", userService.findAllApplicant());
			return map;
		}

		try {
			if (choiseFaculty.getFacultyId() != null) {
				lessonThisFaculty = facultyLessonsService.getAllThisFaculty(choiseFaculty.getFacultyId());
			}

		} catch (Exception e) {
		}

		try {
			if (user.getApplicantss().getAccepted()) {

				ModelAndView mapAccepted = new ModelAndView("message_user");
				mapAccepted.addObject("user", user);
				mapAccepted.addObject("message",
						"Congratulations, you are accepted into our " + "educational institution at the faculty  --  "
								+ user.getApplicantss().getFacultys().getName());
				return mapAccepted;
			}
			if (user.getApplicantss().getRejected()) {
				ModelAndView mapRejected = new ModelAndView("message_user");
				mapRejected.addObject("user", user);
				mapRejected.addObject("message", "Unfortunately, Your application for admission to the faculty "
						+ user.getApplicantss().getFacultys().getName() + " is rejected ");
				return mapRejected;
			}
			if (user.getApplicantss().getChecked()) {
				ModelAndView mapChecked = new ModelAndView("message_user");
				mapChecked.addObject("user", user);
				mapChecked.addObject("message",
						"Your data has been verified. Later, a decision "
								+ "will be made regarding your admission to the faculty  --  "
								+ user.getApplicantss().getFacultys().getName());
				return mapChecked;
			}

		} catch (Exception e) {
		}

		ModelAndView map = new ModelAndView("user");
		List<Faculty> allAndChoiseFaculty = new ArrayList<>();
		allAndChoiseFaculty.add(choiseFaculty);
		allAndChoiseFaculty.addAll(facultyService.getAllFaculty());

		map.addObject("faculties", allAndChoiseFaculty);
		map.addObject("selectFaculty", new Faculty());
		map.addObject("lessonThisFaculty", lessonThisFaculty);

		return map;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView addFacultyLessons(@ModelAttribute("selectFaculty") Faculty faculty) {

		try {
			if (faculty.getFacultyId() != null) {
				choiseFaculty = new Faculty(facultyService.findByFacultyId(faculty.getFacultyId()));
			}
		} catch (Exception e) {
		}
		ModelAndView map = new ModelAndView("redirect:/user");

		return map;
	}

	@RequestMapping(value = "/userball", method = RequestMethod.POST)
	public ModelAndView userPointPost(Authentication authentication, @RequestParam(required = false) Double ballgpa,
			@RequestParam(value = "ball", required = false) Double[] ball) throws IOException {

		int i = 0;
		User user = userService.findByAssignedId(authentication.getName()).get();
		Boolean checked = false;
		try {
			checked = user.getApplicantss().getChecked();
		} catch (Exception e) {
		}

		Applicant aplicant = new Applicant(userService.findByAssignedId(authentication.getName()).get(), choiseFaculty);

		if (checked) {
			return new ModelAndView("redirect:/apl_success");
		}

		Double pointsForBall = 0.0;
		try {
			for (int j = 0; j < ball.length; j++) {
				pointsForBall += ball[j] == null ? 0.0 : ball[j];
			}
			pointsForBall /= ball.length;
			pointsForBall += aplicant.getBallgpa();
		} catch (Exception e) {
		}

		aplicant.setBallgpa(ballgpa);
		aplicant.setChecked(false);
		aplicant.setAccepted(false);
		aplicant.setRejected(false);
		aplicant.setPointsForBall(pointsForBall);

		if (!applicantService.isExist(user)) {
			pointService.delete(user);
		}

		for (Iterator<FacultyLessons> iterator = lessonThisFaculty.iterator(); iterator.hasNext();) {
			FacultyLessons facultyLessons = (FacultyLessons) iterator.next();
			NameOfLesson lesson = facultyLessons.getNameOfLessons();

			try {
				pointService.save(new Point(lesson, aplicant, ball[i]));
			} catch (Exception e) {
			}

			i++;
		}

		return new ModelAndView("redirect:/apl_success");
	}

	@RequestMapping(value = { "/apl_success" }, method = RequestMethod.GET)
	public String ifCheked(Model model) {
		return "apl_success";
	}

	@RequestMapping(value = { "/application_of_entrants" }, method = RequestMethod.GET)
	public ModelAndView entrants(ModelMap model) {
		ModelAndView map = new ModelAndView("application_of_entrants");
		map.addObject("users", userService.findAllApplicant());
		map.addObject("checked", new Applicant());
		map.addObject("accepted", new Applicant());

		return map;
	}

	@RequestMapping(value = "/application_of_entrants", method = RequestMethod.POST)
	public ModelAndView entrantsPost(Authentication authentication,
			@RequestParam(value = "applicantId", required = false) String applicantId, ModelMap model)
			throws IOException {
		return new ModelAndView("redirect:/application_of_entrants");
	}

	@RequestMapping(value = "/application_of_entrants_check", method = RequestMethod.GET)
	public ModelAndView checkedGet(@RequestParam(value = "applicantId", required = false) Integer applicantId,
			ModelMap model) throws IOException {

		Applicant applicantss = applicantService.findApplicant(applicantId);

		applicantss.setChecked(!applicantss.getChecked());
		if (!applicantss.getChecked()) {
			applicantss.setAccepted(false);
			applicantss.setRejected(false);
		}

		applicantService.save(applicantss);

		return new ModelAndView("redirect:/application_of_entrants");
	}

	@RequestMapping(value = "/application_of_entrants_accep", method = RequestMethod.GET)
	public ModelAndView acceptedGet(@RequestParam(value = "applicantId", required = false) Integer applicantId,
			ModelMap model) throws IOException {

		Applicant applicantss = applicantService.findApplicant(applicantId);
		if (applicantss.getChecked() || (!applicantss.getChecked() && applicantss.getAccepted())) {
			applicantss.setAccepted(!applicantss.getAccepted());
			if (applicantss.getAccepted() && applicantss.getRejected()) {
				applicantss.setRejected(false);
			}
			applicantService.save(applicantss);
		}

		return new ModelAndView("redirect:/application_of_entrants");
	}

	@RequestMapping(value = "/application_of_entrants_reject", method = RequestMethod.GET)
	public ModelAndView rejectedGet(@RequestParam(value = "applicantId", required = false) Integer applicantId,
			ModelMap model) throws IOException {

		Applicant applicantss = applicantService.findApplicant(applicantId);
		if (applicantss.getChecked()) {
			applicantss.setRejected(!applicantss.getRejected());
			if (applicantss.getAccepted() && applicantss.getRejected()) {
				applicantss.setAccepted(false);
			}
			applicantService.save(applicantss);
		}

		return new ModelAndView("redirect:/application_of_entrants");
	}

	@RequestMapping(value = { "/singleApplicant" }, method = RequestMethod.GET)
	public ModelAndView details(@RequestParam(value = "assignedId") String assignedId, ModelMap model) {

		User user = userService.findByAssignedId(assignedId).get();
		Applicant applicant = user.getApplicantss();
		ModelAndView map = new ModelAndView("singleApplicant");

		List<LessonDTO> lessonDTOs = new ArrayList<>();
		List<Point> points = pointService.findByApplicant(applicant);
		for (Point point : points) {
			lessonDTOs.add(new LessonDTO(point.getNameOfLesson().getName(), point.getBall()));
		}

		map.addObject("userSingle", user);
		map.addObject("lessons", lessonDTOs);

		return map;
	}

	@RequestMapping(value = { "/singleApplicant" }, method = RequestMethod.POST)
	public ModelAndView detailsPost(Authentication authentication, @RequestParam(required = false) Double ballgpa,
			@RequestParam(value = "ball", required = false) Double[] ball,
			@RequestParam(required = false) String assignedId) {

		ModelAndView map = new ModelAndView("redirect:/application_of_entrants");

		int i = 0;
		User user = userService.findByAssignedId(assignedId).get();
		Applicant applicant = user.getApplicantss();

		applicant.setBallgpa(ballgpa);
		Double sumOfPoint = 0.0;
		for (int j = 0; j < ball.length; j++) {
			sumOfPoint += ball[j] == null ? 0.0 : ball[j];
		}
		applicant.setPointsForBall(applicant.getBallgpa() + sumOfPoint / ball.length);

		List<Point> points = pointService.findByApplicant(applicant);
		for (Point point : points) {

			point.setBall(ball[i]);

			try {
				pointService.save(point);
			} catch (Exception e) {
			}
			i++;
		}
		return map;
	}
	
	@RequestMapping(value = { "/selection_options" }, method = RequestMethod.GET)
	public ModelAndView selectionOptions() {
		ModelAndView map = new ModelAndView("selection_options");
		return map;		
	}	

	@RequestMapping(value = { "/selection_options_check" }, method = RequestMethod.GET)
	public ModelAndView selectionOptionsGet(Model model) {

		ModelAndView map = new ModelAndView("redirect:/application_of_entrants");

		List<Applicant> allApplicant = applicantService.getAllApplicant();
		for (Applicant applicant : allApplicant) {

			boolean checked = true;
			List<Point> points = pointService.findByApplicant(applicant);
			for (Point point : points) {
				if (point.getBall() == null || (point.getBall() < 1) || (point.getBall() > 12)
						|| point.getBall() % 1 != 0) {
					checked = false;
				}
			}
			if (checked) {
				if (applicant.getBallgpa() < 1 || applicant.getBallgpa() > 12) {
					checked = false;
				}
			}
			applicant.setChecked(checked);
			applicantService.save(applicant);
		}
		return map;
	}

	@RequestMapping(value = { "/selection_options" }, method = RequestMethod.POST)
	public ModelAndView selectionOptionsPost(@RequestParam(value = "totalBall", required = false) Double totalBall,
			@RequestParam(value = "number", required = false) Integer number) {

		ModelAndView map = new ModelAndView("redirect:/application_of_entrants");
		List<Applicant> allApplicant = applicantService.getAllApplicant();

		Collections.sort(allApplicant, new ComparatorApplicant());

		int i = 1;
		for (Applicant applicant : allApplicant) {

			if (applicant.getChecked()) {

				if (applicant.getPointsForBall() >= totalBall && i <= number) {
					applicant.setAccepted(true);
					applicant.setRejected(false);
					i++;
				} else {
					applicant.setAccepted(false);
					applicant.setRejected(true);
				}
				
				applicantService.save(applicant);
				
			}

		}

		return map;
	}

}

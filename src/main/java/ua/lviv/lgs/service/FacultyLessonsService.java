package ua.lviv.lgs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyLessonsRepository;
import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;

@Service
public class FacultyLessonsService {

	private Logger logger = LoggerFactory.getLogger(FacultyLessonsService.class);

	@Autowired
	private FacultyLessonsRepository facultyLessonsRepository;

	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;

	public void addFacultyLessons(FacultyLessons facultyLessons) {

		logger.info("Create facultyLessons {} : " + facultyLessons);
		facultyLessonsRepository.save(facultyLessons);
	}

	public List<FacultyLessons> getAll() {

		logger.info("List<FacultyLessons> getAll {} : ");
		return facultyLessonsRepository.findAll();
	}

	public List<FacultyLessons> getAllThisFaculty(Integer facultyId) {

		logger.info("List<FacultyLessons> getAllThisFaculty by facultyId {} : " + facultyId);
		return facultyLessonsRepository.findAll().stream()
				.filter(faculeson -> faculeson.getFacultys().getFacultyId() == facultyId).collect(Collectors.toList());
	}

	public List<NameOfLesson> getLessonsOfThisFaculty(Integer facultyId) {

		logger.info("List<NameOfLesson> getLessonsOfThisFaculty {} : " + facultyId);

		try {
			List<FacultyLessons> lessonsOfThisFaculty = facultyLessonsRepository.findAll().stream()
					.filter(faculeson -> faculeson.getFacultys().getFacultyId() == facultyId)
					.collect(Collectors.toList());

			List<NameOfLesson> lessonFaculty = new ArrayList<>();

			for (FacultyLessons facultyLessons : lessonsOfThisFaculty) {
				lessonFaculty
						.add(nameOfLessonRepository.findByLessonId(facultyLessons.getNameOfLessons().getLessonId()));
			}

			return lessonFaculty;
		} catch (Exception e) {
		}

		return null;
	}

	public void delete(FacultyLessons facultyLessons) {

		logger.info("Delete facultyLessons {} : " + facultyLessons);
		facultyLessonsRepository.delete(facultyLessons);
	}

}

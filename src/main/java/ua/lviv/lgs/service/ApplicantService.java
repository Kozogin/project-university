package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ApplicantRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.User;

@Service
public class ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Boolean isExist(User user) {	
		try {
			return applicantRepository.findByUserss(user).getUserss().getUserId() 
					== user.getUserId() ? false: true;
		} catch (Exception e) {}
		return true;		
	}
	
	public Applicant findApplicant(Integer applicantId) {
		return applicantRepository.findByApplicantId(applicantId);		
	}
	
	public void save(Applicant applicant) {
		applicantRepository.save(applicant);
	}

}

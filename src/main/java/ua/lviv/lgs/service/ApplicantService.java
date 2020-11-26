package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ApplicantRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.User;

@Service
public class ApplicantService {
	
	private Logger logger = LoggerFactory.getLogger(ApplicantService.class);
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Boolean isExist(User user) {	
		
		logger.info("is exist user {} : " + user);
		try {
			return applicantRepository.findByUserss(user).getUserss().getUserId() 
					== user.getUserId() ? false: true;
		} catch (Exception e) {}
		return true;		
	}
	
	public Applicant findApplicant(Integer applicantId) {
		
		logger.info("find applicant by applicantId {} : " + applicantId);
		return applicantRepository.findByApplicantId(applicantId);		
	}
	
	public void save(Applicant applicant) {
		
		logger.info("Create applicant {} : " + applicant);
		applicantRepository.save(applicant);
	}
	
	public List<Applicant> getAllApplicant(){
		
		logger.info("List<Applicant> getAllApplicant {} : ");
		return applicantRepository.findAll();		
	}
	

}

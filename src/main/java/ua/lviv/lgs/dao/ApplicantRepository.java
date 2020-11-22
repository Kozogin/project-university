package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.User;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{
	
	Applicant findByUserss(User user);
	
	Applicant findByApplicantId(Integer applicantId);

}

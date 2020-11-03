package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

}

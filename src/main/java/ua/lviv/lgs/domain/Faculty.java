package ua.lviv.lgs.domain;

import java.util.HashSet;
import java.util.Set;
 
public class Faculty {
	
	private Integer facultyId;
	private String name;
	private Set<NameOfLesson> nameOfLessons = new HashSet<>();
	private Set<Applicant> applicants = new HashSet<>();
	
	public Faculty(Integer facultyId, String name, Set<NameOfLesson> nameOfLessons, Set<Applicant> applicants) {
		this.facultyId = facultyId;
		this.name = name;
		this.nameOfLessons = nameOfLessons;
		this.applicants = applicants;
	}
	
	public Faculty(String name, Set<NameOfLesson> nameOfLessons, Set<Applicant> applicants) {
		this.name = name;
		this.nameOfLessons = nameOfLessons;
		this.applicants = applicants;
	}
	
	public Faculty() {}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<NameOfLesson> getNameOfLessons() {
		return nameOfLessons;
	}

	public void setNameOfLessons(Set<NameOfLesson> nameOfLessons) {
		this.nameOfLessons = nameOfLessons;
	}

	public Set<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Applicant> applicants) {
		this.applicants = applicants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (facultyId == null) {
			if (other.facultyId != null)
				return false;
		} else if (!facultyId.equals(other.facultyId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", name=" + name + "]";
	}

	
}

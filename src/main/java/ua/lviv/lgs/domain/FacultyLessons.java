package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_lesson")
public class FacultyLessons {
	
	@Id
	@GeneratedValue
	@Column(name = "fl_id")
	private Integer facultyLessonsId;	

	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
	private Faculty facultys;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
	private NameOfLesson nameOfLessons;

	public FacultyLessons(Integer facultyLessonsId, Faculty facultys, NameOfLesson nameOfLessons) {
		this.facultyLessonsId = facultyLessonsId;
		this.facultys = facultys;
		this.nameOfLessons = nameOfLessons;
	}
	
	public FacultyLessons(Faculty facultys, NameOfLesson nameOfLessons) {
		this.facultys = facultys;
		this.nameOfLessons = nameOfLessons;
	}
	
	public FacultyLessons() {}

	public Integer getFacultyLessonsId() {
		return facultyLessonsId;
	}

	public void setFacultyLessonsId(Integer facultyLessonsId) {
		this.facultyLessonsId = facultyLessonsId;
	}

	public Faculty getFacultys() {
		return facultys;
	}

	public void setFacultys(Faculty facultys) {
		this.facultys = facultys;
	}

	public NameOfLesson getNameOfLessons() {
		return nameOfLessons;
	}

	public void setNameOfLessons(NameOfLesson nameOfLessons) {
		this.nameOfLessons = nameOfLessons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyLessonsId == null) ? 0 : facultyLessonsId.hashCode());
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
		FacultyLessons other = (FacultyLessons) obj;
		if (facultyLessonsId == null) {
			if (other.facultyLessonsId != null)
				return false;
		} else if (!facultyLessonsId.equals(other.facultyLessonsId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacultyLessons [facultyLessonsId=" + facultyLessonsId + "]";
	}
	
	
	
	

}

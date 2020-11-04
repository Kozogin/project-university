package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name_of_lesson")
public class NameOfLesson {
	
	@Id
	@GeneratedValue
	@Column(name = "lesson_id")
	private Integer lessonId;
	
	@Column
	private String name;	
	
	public NameOfLesson(Integer lessonId, String name) {
		this.lessonId = lessonId;
		this.name = name;
		}
	
	public NameOfLesson(String name) {
		this.name = name;
	}
	
	public NameOfLesson() {}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lessonId == null) ? 0 : lessonId.hashCode());
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
		NameOfLesson other = (NameOfLesson) obj;
		if (lessonId == null) {
			if (other.lessonId != null)
				return false;
		} else if (!lessonId.equals(other.lessonId))
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
		return "NameOfLesson [lessonId=" + lessonId + ", name=" + name + "]";
	}

}

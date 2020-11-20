package ua.lviv.lgs.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "point_id")
	private Integer pointId;
		
	@ManyToOne
	@JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
	private NameOfLesson nameOfLesson;	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
	private Applicant applicant;
		
	@Column
	private Double ball;

	public Point(Integer pointId, NameOfLesson nameOfLesson, Applicant applicant, Double ball) {
		this.pointId = pointId;
		this.nameOfLesson = nameOfLesson;
		this.applicant = applicant;
		this.ball = ball;
	}
	
	public Point(NameOfLesson nameOfLesson, Applicant applicant, Double ball) {
		this.nameOfLesson = nameOfLesson;
		this.applicant = applicant;
		this.ball = ball;
	}
	
	public Point() {}

	public Integer getPointId() {
		return pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public NameOfLesson getNameOfLesson() {
		return nameOfLesson;
	}

	public void setNameOfLesson(NameOfLesson nameOfLesson) {
		this.nameOfLesson = nameOfLesson;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Double getBall() {
		return ball;
	}

	public void setBall(Double ball) {
		this.ball = ball;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ball == null) ? 0 : ball.hashCode());
		result = prime * result + ((pointId == null) ? 0 : pointId.hashCode());
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
		Point other = (Point) obj;
		if (ball == null) {
			if (other.ball != null)
				return false;
		} else if (!ball.equals(other.ball))
			return false;
		if (pointId == null) {
			if (other.pointId != null)
				return false;
		} else if (!pointId.equals(other.pointId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [pointId=" + pointId + ", ball=" + ball + "]";
	}	
	
}

package ua.lviv.lgs.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicant")
public class Applicant{
	
	@Id
	@GeneratedValue
	@Column(name = "applicant_id")
	private Integer applicantId;
	
	@Column
	private Boolean checked;
	
	@Column
	private Boolean accepted;
	
	@Column
	private Boolean rejected;
	
	@Column(name="points_for_ball")
	private Double pointsForBall;
	
	@Column
	private Double ballgpa;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "applicant_id2", referencedColumnName = "user_id")	
	private User userss;
		
	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")	
	private Faculty facultys;		
	
	public Applicant(Integer applicantId, Boolean checked, Boolean accepted, Boolean rejected, Double pointsForBall, Double ballgpa,
			User userss, Faculty facultys) {
		this.applicantId = applicantId;
		this.checked = checked;
		this.accepted = accepted;
		this.rejected = rejected;
		this.pointsForBall = pointsForBall;
		this.ballgpa = ballgpa;
		this.userss = userss;
		this.facultys = facultys;
	}	

	public Applicant(Boolean checked, Boolean accepted, Boolean rejected, Double pointsForBall, Double ballgpa, User userss,
			Faculty facultys) {
		this.checked = checked;
		this.accepted = accepted;
		this.rejected = rejected;
		this.pointsForBall = pointsForBall;
		this.ballgpa = ballgpa;
		this.userss = userss;
		this.facultys = facultys;
	}

	public Applicant(User userss, Faculty facultys) {		
		this.userss = userss;
		this.facultys = facultys;
	}
	
	public Applicant() {}



	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
		if(!checked) {
			this.accepted = false;
			this.rejected = false;
		}
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}	

	public Boolean getRejected() {
		return rejected;
	}

	public void setRejected(Boolean rejected) {
		this.rejected = rejected;
	}

	public Double getPointsForBall() {
		return pointsForBall;
	}

	public void setPointsForBall(Double pointsForBall) {
		this.pointsForBall = pointsForBall;
	}

	public Double getBallgpa() {
		return ballgpa;
	}

	public void setBallgpa(Double ballgpa) {
		this.ballgpa = ballgpa;
	}

	public User getUserss() {
		return userss;
	}

	public void setUserss(User userss) {
		this.userss = userss;
	}

	public Faculty getFacultys() {
		return facultys;
	}

	public void setFacultys(Faculty facultys) {
		this.facultys = facultys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accepted == null) ? 0 : accepted.hashCode());
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((ballgpa == null) ? 0 : ballgpa.hashCode());
		result = prime * result + ((checked == null) ? 0 : checked.hashCode());
		result = prime * result + ((pointsForBall == null) ? 0 : pointsForBall.hashCode());
		result = prime * result + ((rejected == null) ? 0 : rejected.hashCode());
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
		Applicant other = (Applicant) obj;
		if (accepted == null) {
			if (other.accepted != null)
				return false;
		} else if (!accepted.equals(other.accepted))
			return false;
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (ballgpa == null) {
			if (other.ballgpa != null)
				return false;
		} else if (!ballgpa.equals(other.ballgpa))
			return false;
		if (checked == null) {
			if (other.checked != null)
				return false;
		} else if (!checked.equals(other.checked))
			return false;
		if (pointsForBall == null) {
			if (other.pointsForBall != null)
				return false;
		} else if (!pointsForBall.equals(other.pointsForBall))
			return false;
		if (rejected == null) {
			if (other.rejected != null)
				return false;
		} else if (!rejected.equals(other.rejected))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", checked=" + checked + ", accepted=" + accepted
				+ ", rejected=" + rejected + ", pointsForBall=" + pointsForBall + ", ballgpa=" + ballgpa + "]";
	}
	

}

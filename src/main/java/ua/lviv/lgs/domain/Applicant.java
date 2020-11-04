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
	private Integer pointId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_id2", referencedColumnName = "user_id")	
	private User userss;
		
	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")	
	private Faculty facultys;

	public Applicant(Integer applicantId, Boolean checked, Boolean accepted, Integer pointId, Integer userId,
			User userss, Faculty facultys) {
		this.applicantId = applicantId;
		this.checked = checked;
		this.accepted = accepted;
		this.pointId = pointId;
		this.userId = userId;
		this.userss = userss;
		this.facultys = facultys;
	}
	
	public Applicant(Boolean checked, Boolean accepted, Integer pointId, Integer userId,
			User userss, Faculty facultys) {
		this.checked = checked;
		this.accepted = accepted;
		this.pointId = pointId;
		this.userId = userId;
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
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Integer getPointId() {
		return pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		result = prime * result + ((checked == null) ? 0 : checked.hashCode());
		result = prime * result + ((pointId == null) ? 0 : pointId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (checked == null) {
			if (other.checked != null)
				return false;
		} else if (!checked.equals(other.checked))
			return false;
		if (pointId == null) {
			if (other.pointId != null)
				return false;
		} else if (!pointId.equals(other.pointId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", checked=" + checked + ", accepted=" + accepted
				+ ", pointId=" + pointId + ", userId=" + userId + "]";
	}
		

}

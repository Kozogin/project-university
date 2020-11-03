package ua.lviv.lgs.domain;

public class Applicant {
	
	private Integer applicantId;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean checked;
	private Boolean accepted;	
	private Integer pointId;
	private Integer userId;
	private Faculty faculty;
	
	public Applicant(Integer applicantId, String firstName, String lastName, String email, Boolean checked,
			Boolean accepted, Integer pointId, Integer userId, Faculty faculty) {
		this.applicantId = applicantId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.checked = checked;
		this.accepted = accepted;
		this.pointId = pointId;
		this.userId = userId;
		this.faculty = faculty;
	}
	
	public Applicant(String firstName, String lastName, String email, Boolean checked,
			Boolean accepted, Integer pointId, Integer userId, Faculty faculty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.checked = checked;
		this.accepted = accepted;
		this.pointId = pointId;
		this.userId = userId;
		this.faculty = faculty;
	}
	
	public Applicant() {}
	
	public Applicant(String firstName, String lastName, String email, Faculty faculty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.faculty = faculty;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accepted == null) ? 0 : accepted.hashCode());
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((checked == null) ? 0 : checked.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
		return "Applicant [applicantId=" + applicantId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", checked=" + checked + ", accepted=" + accepted + ", pointId=" + pointId
				+ ", userId=" + userId + "]";
	}	
	

}

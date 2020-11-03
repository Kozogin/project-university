package ua.lviv.lgs.domain;

import java.util.Date;

public class User {
	
	private Integer userId;
	private String assignedId;
	private String password;
	private Role role;
	private Date purchaseDate;
	
	public User(Integer userId, String assignedId, String password, Role role, Date purchaseDate) {
		this.userId = userId;
		this.assignedId = assignedId;
		this.password = password;
		this.role = role;
		this.purchaseDate = purchaseDate;
	}
	
	public User(String assignedId, String password, Role role, Date purchaseDate) {
		this.assignedId = assignedId;
		this.password = password;
		this.role = role;
		this.purchaseDate = purchaseDate;
	}
	
	public User() {}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAssignedId() {
		return assignedId;
	}

	public void setAssignedId(String assignedId) {
		this.assignedId = assignedId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedId == null) ? 0 : assignedId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		User other = (User) obj;
		if (assignedId == null) {
			if (other.assignedId != null)
				return false;
		} else if (!assignedId.equals(other.assignedId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (role != other.role)
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
		return "User [userId=" + userId + ", assignedId=" + assignedId + ", password=" + password + ", role=" + role
				+ ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}

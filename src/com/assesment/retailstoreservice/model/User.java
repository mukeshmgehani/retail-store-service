/**
 * 
 */
package com.assesment.retailstoreservice.model;

import java.time.LocalDateTime;

/**
 * @author mukeshgehani
 *
 *This class is used for user registration
 */
public class User {

	private UserType userType;
	private String name;
	private LocalDateTime joiningDate;

	/**
	 * @param userType
	 * @param name
	 */
	public User(UserType userType, String name) {
		super();
		this.userType = userType;
		this.name = name;
		this.joiningDate =  LocalDateTime.now();
	}
	

	/**
	 * @param userType
	 * @param name
	 * @param joiningDate
	 */
	public User(UserType userType, String name, LocalDateTime joiningDate) {
		super();
		this.userType = userType;
		this.name = name;
		this.joiningDate = joiningDate;
	}


	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the joiningDate
	 */
	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate
	 *            the joiningDate to set
	 */
	public void setJoiningDate(LocalDateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userType=");
		builder.append(userType);
		builder.append(", name=");
		builder.append(name);
		builder.append(", joiningDate=");
		builder.append(joiningDate);
		builder.append("]");
		return builder.toString();
	}

}

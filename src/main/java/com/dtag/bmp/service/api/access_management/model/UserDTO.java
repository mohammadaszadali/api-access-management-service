package com.dtag.bmp.service.api.access_management.model;

import java.io.Serializable;
import java.util.List;

public class UserDTO  {

	private static final long serialVersionUID = 1L;
	private String userName;

	private String emailId;

	private String familyName;

	private String givenName;

	private String password;

	public UserDTO()

	{

	}
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", emailId=" + emailId + ", familyName=" + familyName + ", givenName="
				+ givenName + ", password=" + password + "]";
	}

	

	
	

	
	
	
}

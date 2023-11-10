package com.order.entity;




public class User {
	
	private String id;
	
	private String uName;
	
	private String uEmail;
	private String uPassword;
	
	private String uMobile;
	private String uRole;
	
	
	

	public User(String id, String uName, String uEmail, String uPassword, String uMobile, String uRole) {
		super();
		this.id = id;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uMobile = uMobile;
		this.uRole = uRole;
	}




	public User() {
		super();
	}
	
	

	
	public String getuName() {
		return uName;
	}
	
	




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}


	public String getuMobile() {
		return uMobile;
	}
	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}
	public String getuRole() {
		return uRole;
	}
	public void setuRole(String uRole) {
		this.uRole = uRole;
	}


	@Override
	public String toString() {
		return "User [userid=" + id + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword
				+ ", uMobile=" + uMobile + ", uRole=" + uRole + "]";
	}


	
	
	
	
	
	
	
	
	
}

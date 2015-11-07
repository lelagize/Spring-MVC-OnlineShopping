package com.tadtab.account;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport {
	
	public String execute(){
		
		Member member = new Member();
		member.setUsername(getUsername());
		member.setPassword(getPassword());
		member.setAge(getAge());
		member.setEmail(getEmail());
		member.setBirthday(getBirthday());
		member.setFirstName(getFirstName());
		member.setLastName(getLastName());
		member.setUserId(getUserId());
		
		getSignUp().createAccount(member);
		
		return SUCCESS;
		
	}
	
	private String userId;
	private String username;
	private String password;
	private Double age;
	private Date birthday;
	private String firstName;
	private String lastName;
	private String email;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	
	
	public SignUp getSignUp(){
		return new SignUp();
	}
	

}

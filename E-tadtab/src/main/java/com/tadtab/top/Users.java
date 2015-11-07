package com.tadtab.top;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;

@Entity(name="userSign")
public class Users {
	@Id
	private String username;
	private String password;
	@Value("1")
	private boolean enabled;
	@OneToMany
	@Value("ROLE_USER")
	private List<UserRoles> userrole;
	
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<UserRoles> getUserrole() {
		return userrole;
	}
	public void setUserrole(List<UserRoles> userrole) {
		this.userrole = userrole;
	}
	
	
	
	

}

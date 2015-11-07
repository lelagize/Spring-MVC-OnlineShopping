package com.tadtab.top;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="user_roles")
public class UserRoles {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long user_role_id;
	@NotNull
	private String role;
	
	public long getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(long user_role_id) {
		this.user_role_id = user_role_id;
	}
	
}

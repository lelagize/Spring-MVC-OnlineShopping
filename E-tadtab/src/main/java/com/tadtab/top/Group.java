package com.tadtab.top;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Id; 
@Entity
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long groupId;
	private String groupName;
	private String groupCode;
	
	public Group() {}
	
	public Group(String groupName, String code) {
		this.groupName = groupName;
		this.groupCode = code;
	}
	public String groupCode() {
		return groupCode;
	}
	public void setCode(String code) {
		this.groupCode = code;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	

}

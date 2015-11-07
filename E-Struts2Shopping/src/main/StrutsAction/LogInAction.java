package main.StrutsAction;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class LogInAction extends ActionSupport {
	
	private String userName;
	private String password;
	
	/*public String execute(){
		
		
		
	}*/
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void validate(){
		
		if(getUserName().length() == 0){
			addFieldError("userName", getText("userName.required"));
		}
		
		if(getPassword().length() == 0){
			addFieldError("password", getText("password.required"));
		}
		
	}

}

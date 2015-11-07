package com.tadtab.top;

public class CanNotRegisterCustomer extends Exception {
	
	private String firstName;
	private String lasstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasstName() {
		return lasstName;
	}

	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}

	public CanNotRegisterCustomer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lasstName = lastName;
	}

	@Override
	public String toString() {
		return "CanNotRegisterCustomer [firstName=" + firstName
				+ ", lasstName=" + lasstName + "]";
	}
	
	

}

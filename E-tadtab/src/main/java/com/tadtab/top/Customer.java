package com.tadtab.top;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Primary;

@Entity(name="member")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long personId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	
	private int zipCode;
	@NotNull
	@Min(10)
	private long phonenumber;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	
	
	public Customer(String firstName, String lastName, int zipCode,
			long phonenumber,  String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.phonenumber = phonenumber;
		this.userName = userName;
		this.password = password;
	}

	public Customer() {
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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


}

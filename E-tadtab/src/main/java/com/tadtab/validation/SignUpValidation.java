package com.tadtab.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tadtab.top.Customer;

@Component
public class SignUpValidation implements Validator {

	@Override
	 public boolean supports(Class clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }
	

	@Override
	public void validate(Object target, Errors errors) {
	
		// check each filed against a special case and reject it if it
		//does not fulfill it
		
		// Use ValidationUtils class and its static methods to reject fields
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "required.firstName", "First name is Required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "required.lastName", "Last name is Required");
		ValidationUtils.rejectIfEmpty(errors, "zipCode", "required.zipCode", "Zip Code is Required");
		ValidationUtils.rejectIfEmpty(errors, "phonenumber", "required.phonenumber", "Phone Number is Required");
		ValidationUtils.rejectIfEmpty(errors, "userName", "required.userName", "User Name is Required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required.password", "password is Required");
		//	 define the target object
		
		Customer cust = (Customer)target;
		Integer zip = cust.getZipCode();
		Long phoneNum = cust.getPhonenumber();
		
		//	 check the phone number and see if it is 10 digit 
		
		if((phoneNum != null) && (Long.toString(phoneNum).length() != 10)){
			errors.reject("invalid.phonenumber", " Phone Number has to be 10 digits long");
		}
		
		if((zip != null) && (Long.toString(zip).length() != 10)){
			errors.reject("invalid.zipCode", " Zip Code has to be 5 digits long");
		}
		
		
	}

}

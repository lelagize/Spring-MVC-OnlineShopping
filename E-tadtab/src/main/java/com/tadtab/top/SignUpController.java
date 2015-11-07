package com.tadtab.top;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tadtab.service.SignUpService;
import com.tadtab.validation.SignUpValidation;
@Controller
@RequestMapping("/signUp")
@SessionAttributes("customer")
public class SignUpController {
	
	private SignUpService signUpService;
	private SignUpValidation signUpValidation;
	
	@Autowired
	public SignUpController(SignUpService signUpService) {
		this.signUpService = signUpService;
		this.signUpValidation = signUpValidation;
	}
	//create a get method that  will be used return a new instance of the customer object
	@RequestMapping(method = RequestMethod.GET )
	public String generateForm( Model model){
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		return "signUp";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String processForm(@ModelAttribute("customer") @Valid Customer customer, 
			BindingResult result, SessionStatus status) throws Exception{
		//create a reference for the registration service
		//call the service method
		//
		if(result.hasErrors()){
			return "signUp";
		}else{
			System.out.println("This should Call only once");
			signUpService.registerCustomer(customer);
			status.setComplete();
			return "registrationSuccess";
		}
	}
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.setValidator(signUpValidation);
	    }
	
}

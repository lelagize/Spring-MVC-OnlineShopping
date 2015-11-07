package com.tadtab.top.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tadtab.service.SingInService;
import com.tadtab.top.Customer;
import com.tadtab.top.SignIn;
@Controller
@RequestMapping("/signIn")
@SessionAttributes("signIn")
public class SignInController {
	
	private SingInService singInService;
	
	@Autowired
	public SignInController(SingInService singInService) {
		this.singInService = singInService;
	}

	//	call the service method to find out if the 
	//	customer object is registered
	//	if it does return sign in successfull
	// 	if it does not return error saying no matching object found
	// 
	//	This is handles in the post method
	
	@RequestMapping(method = RequestMethod.GET)
	public String generateForm(Model model){
		SignIn signIn = new SignIn();
		model.addAttribute("signIn", signIn);
		return "signIn";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String decisionView(@Valid SignIn signIn,
            BindingResult result, SessionStatus status){
		Boolean bool = singInService.isCustomerRegistered(signIn);
		if(result.hasErrors()){
			return "signIn";
		}else{
			if(bool){
				return "signInSuccessfull";
			}else{
				return "signInUnsuccessFull";
			}
		}
	}

}

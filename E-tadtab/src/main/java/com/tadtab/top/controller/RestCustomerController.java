package com.tadtab.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tadtab.service.RestCustomerService;
import com.tadtab.service.SingInService;
import com.tadtab.top.Customer;
import com.tadtab.topRest.Members;

@Controller
public class RestCustomerController {
	
	private RestCustomerService restCustomerService;
	
	@Autowired
	public RestCustomerController(RestCustomerService restCustomerService) {
		this.restCustomerService = restCustomerService;
	}

	@RequestMapping("/members")
	@ResponseBody
	public Members generateXmlRepresentation( Model model){
		Members members = new Members();
		members.addAllMembers(restCustomerService.findAllMembers());
		model.addAttribute("members", members);
		return members;
	}
	
	
	
	@RequestMapping("/member/{firstName}")
	@ResponseBody
	public ResponseEntity<Customer> generateXmlRepresentation(@PathVariable String firstName){
		
		// get all members and iterate over 
		//
		
		Customer cust =  restCustomerService.getAcustomer(firstName);
		
		if(cust != null){
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		}else{
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	

}

package com.tadtab.top.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadtab.service.MessageServiceImpl;
import com.tadtab.top.Message;


@Controller
@RequestMapping("/messagePost*")
public class PostMessagesController {
	
	MessageServiceImpl messageServiceImpl;	
	
	@Autowired
	public PostMessagesController(MessageServiceImpl messageServiceImpl) {
		this.messageServiceImpl = messageServiceImpl;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String generateForm(Model model){
		Message message = new Message();
		model.addAttribute("message", message);
		return "messageForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postmessage(@ModelAttribute("message")Message message, BindingResult result){
		if(result.hasErrors()){
			 return "messageForm";
		}else{
		messageServiceImpl.postAMessage(message);
		return "messageSent";
		}
	}
}


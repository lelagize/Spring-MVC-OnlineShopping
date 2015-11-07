package com.tadtab.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tadtab.service.MessageServiceImpl;
import com.tadtab.top.Message;


@Controller
@RequestMapping("/")
public class ListMessagesController {
	
	private MessageServiceImpl messageServiceImpl;
	
	@Autowired
	public ListMessagesController(MessageServiceImpl messageServiceImpl) {
		super();
		this.messageServiceImpl = messageServiceImpl;
	}


	@RequestMapping(value = "/listAllMessages", method = RequestMethod.GET)
	public String findAllMessages(Model model){
		List<Message> messages = java.util.Collections.emptyList();
		messages = messageServiceImpl.listOfMessages();
		model.addAttribute("messages", messages);
		return "allMessages";
	}


}

package com.tadtab.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tadtab.service.MessageServiceImpl;

@Controller
@RequestMapping("/messageDelete*")
public class DeleteMessageController {
	
	private MessageServiceImpl messageServiceImpl;
	
	@Autowired
	public DeleteMessageController(MessageServiceImpl messageServiceImpl) {
		this.messageServiceImpl = messageServiceImpl;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String deleteAmessage(@RequestParam(required=true, value="messageId") Long messageId, Model model){
		// find all messages
		// compare agains the Id
		// delete that particular message object
		// add the rest messages back to the model
				
		messageServiceImpl.deleteAMessage(messageId);
		model.addAttribute("messages", messageServiceImpl.listOfMessages());
		
		return "allMessages";
	}

}

package com.tadtab.service;

import java.util.List;

import com.tadtab.top.Message;


public interface MessageService {
	
	// list all messages
	// post message
	// delete message
	// find a message by id
	
	public List<Message> listOfMessages();
	public void postAMessage(Message message);
	public void deleteAMessage(long messageId);
	public Message findAMessageById(long messageId);

}

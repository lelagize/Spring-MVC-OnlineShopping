package com.tadtab.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.tadtab.top.Message;

public class MessageServiceImpl implements MessageService{

	// create a message list which is empty, choose implementation class
	// specific to the actions performed: adding and removing key value pair
	
	Map<Long, Message> messages = new LinkedHashMap<Long, Message>();
	// for all message object, for each get id. then associate that object with its id
	// the add each one into the map object as key and value pair
	
	Session session = null;
		
	public List<Message> listOfMessages(){
		
		List messageList = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
			List<Message> query = session.createQuery("from Message").list();
			messageList = query;
			
			
		session.getTransaction().commit();
		session.close();
		return messageList;
		
	}
	
	public Map<Long, Message> createMessageMap(){
		for(Message message: listOfMessages()){
			messages.put(message.getId(), message);
		}
		return messages;
	}
	public static void main(String[] args){
		System.out.println("hello 1");
		MessageServiceImpl messageServiceImpl = new MessageServiceImpl();
		for(Message mesg : messageServiceImpl.listOfMessages()){
			System.out.println(mesg.getName());
		}
		
	
		
		
	}

	@Override
	public synchronized void postAMessage(Message message) {
		
		// message needs id
		// when storing it to the database, you need to send a message object 
		// with id associated with it
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
			message.setId(System.currentTimeMillis());
			/*messages.put(message.getId(), message);*/
			session.save(message);
			
		session.getTransaction().commit();;
		session.close();
	}

	@Override
	public synchronized void deleteAMessage(long messageId) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		for(Message message : listOfMessages()){
			if(message.getId()==messageId){
				session.delete(message);
			}
		}
			
		session.getTransaction().commit();;
		session.close();
	}

	@Override
	public Message findAMessageById(long messageId) {
		
		for(Message message : listOfMessages()){
			if(message.getId()==messageId){
				return message;
			}
		}
		/*Message message = messages.get(messageId);
		return message;*/
		return null;
	}
	

}

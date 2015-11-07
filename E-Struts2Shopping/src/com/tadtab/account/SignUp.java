package com.tadtab.account;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SignUp {
	
	SessionFactory sessionfactory = new Configuration().buildSessionFactory();
	Session session;
	
	Map members = new HashMap();
	
	public void createAccount(Member member){
				
		 session = sessionfactory.openSession();
		 session.beginTransaction();
		 
		 	if(members.get(member.getEmail()) == null){
		 		
		 		members.put(member.getUserId(), member);
		 		
		 	}
		 	
		 
		 session.getTransaction().commit();
		 session.close();
		
	}

}

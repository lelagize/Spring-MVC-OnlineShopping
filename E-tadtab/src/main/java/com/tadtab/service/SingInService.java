package com.tadtab.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.hibernate.Session;
import com.tadtab.top.Customer;
import com.tadtab.top.SignIn;

public class SingInService {
	Session session = null;
	// retrieve all the members data
	// compare it with the current one
	// if it does not match with any of these, 
	// forward to login page
	// if it does publish a succes message
	
	public List<Customer> RetrieveCustomer(){
		System.out.println("Entered for retrieving list of customers ");
			List customerList = new CopyOnWriteArrayList<Customer>();
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
				List query = session.createQuery("from member").list();
				customerList.addAll(query);
				
				
			session.getTransaction().commit();
			session.close();
			System.out.println("Ready to return the list of customers");
			return customerList;
		}
	
	public boolean isCustomerRegistered(SignIn signIn){
		for(Customer member : RetrieveCustomer()){
			if((signIn.getUserName().equals(member.getUserName())) &&
					(signIn.getPassword().equals(member.getPassword()))){
				return true;
			}
		}
		return false;
	}
	
	public List findAllMembers(){
		return RetrieveCustomer();
	
	}

}

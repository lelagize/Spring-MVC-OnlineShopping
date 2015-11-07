package com.tadtab.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.hibernate.Session;


import com.tadtab.top.Customer;

public class RestCustomerService {
	Session session = null;
	
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
	
	public List findAllMembers(){
		return RetrieveCustomer();
	
	}
	
	public Customer getAcustomer(String firstName){
		for(Customer customer : RetrieveCustomer()){
			if(customer.getFirstName().equals(firstName))
			return customer;
			//	got customer object from the service class
			//	in the controller get that customer
			// based on the pathVariable
		}
		return null;		
	}
	
	public static void main(String[] args){
		RestCustomerService rcs = new RestCustomerService();
		System.out.println(rcs.getAcustomer("Geni"));
	}

}

package com.tadtab.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tadtab.top.CanNotRegisterCustomer;
import com.tadtab.top.Customer;

public class SignUpService {
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = null;
	
	// register the custumer
	// check if the same custumer does not exist
	// if it does, throw exception, saying customer already exists
	// if it does not, add it to the list
	
	private List<Customer> registeredCustomers;
	
	//create empty list
	
		public SignUpService() {
		registeredCustomers = new CopyOnWriteArrayList<Customer>();
		registeredCustomers.addAll(RetrieveCustomer());
		
	}
	// retrieve from db and compare it with incoming data
	//persist to Db
	// 
	public void persistCustomer( String firstName, String lastName, int zipCode, long phonenumber,
			String userName, String password){
		System.out.println("Persisting customer ");
		session = sessionfactory.openSession();
		session.beginTransaction();
		
		Customer cust = new Customer(firstName, lastName, zipCode, phonenumber, userName,  password);
		session.save(cust);
			
		session.getTransaction().commit();
		session.close();
		System.out.println("Finished Persisting customer ");
	}
	public List RetrieveCustomer(){
		System.out.println("Entered for retrieving list of customers ");
			List customerList = new CopyOnWriteArrayList<Customer>();
			session = sessionfactory.openSession();
			session.beginTransaction();
			
				List query = session.createQuery("from member").list();
				customerList.addAll(query);
				
				
			session.getTransaction().commit();
			session.close();
			System.out.println("Ready to return the list of customers");
			return customerList;
		}
	
	public void registerCustomer(Customer customer) throws CanNotRegisterCustomer{
		
		System.out.println("Entered Checking if Customer Exist or not ");
		System.out.println("Fist name = " + customer.getFirstName());
		// iterate over each customer in the RegisteredCustomers an see if there is a match
		// if there is, throw Exception
		// if not add it to the RegisteredCustomers list
		for(Customer member : registeredCustomers){
			
			if((member.getFirstName().equals(customer.getFirstName())) &&
				(member.getLastName().equals(customer.getLastName())))
				
			{
				System.out.println("NOW customer already exists, shoul throw CanNotRegisterCustomer Exception ");
				throw new CanNotRegisterCustomer(customer.getFirstName(),customer.getLastName());
			}
			
			
		}
		System.out.println("Size of the customer = " + registeredCustomers.size());
		System.out.println("Customer does not exist, Going to save it ");
		persistCustomer(customer.getFirstName(), customer.getLastName(), customer.getZipCode(), customer.getPhonenumber(),
				customer.getUserName(), customer.getPassword());
		System.out.println("After saving The customer");		
	}
	
}

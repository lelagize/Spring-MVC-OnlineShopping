package main.Dao;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import main.java.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CustomerDao {
	
	
	Session session = null;
	
	public void validateCustomer(Customer customer){
		
	}
	
	public List<Customer> retrieve(){
		List allCustomer = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		 List list = (List)session.createQuery("from Customer").list();
		 allCustomer = list;
		
		session.getTransaction().commit();
		session.close();
		return allCustomer;
		}
	
	public Customer retrieveACustomer(int id){
		List listofCustomers = retrieve();
		Customer customer = new Customer();
		Iterator it = listofCustomers.iterator();
		while(it.hasNext()){
			if(((Customer)it.next()).getPersonId() == id){
				customer = (Customer)it.next();
			}
		}
		return customer;
	}
	
	public void persistCustomer(Customer customer){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		 customer = new Customer();
		session.save(customer);
	
		session.getTransaction().commit();
		session.clear();
		
	}	
	
	
}

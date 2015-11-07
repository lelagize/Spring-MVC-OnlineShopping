package main.StrutsAction;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import main.Dao.CustomerDao;
import main.java.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport implements SessionAware {
	
	private Customer customer;
		
	public String execute(){
		 Customer customer = new Customer();
		 		
		getCustomerDao().persistCustomer(customer);
		session.put("customer", customer);
		return SUCCESS;
		
	}
	
	private Map session;
		
	
	public CustomerDao getCustomerDao(){
		return new CustomerDao();
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}

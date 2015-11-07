package main.StrutsAction;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import main.Dao.CustomerDao;
import main.java.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport implements SessionAware{
	
	public String execute(){
				
		return SUCCESS;
	}
	
	private Map<String, Object> session;
	
	public void authenticateCustomer(Customer customer, String password){
		List<Customer> custumerList = getCustomerDao().retrieve();
		/*retrive all custumers form the database
		 * check if the customer in the argument is in the list
		 * If it is return it 
		 * If it is not in the list return null
		 * 
		 * */
		if(custumerList.contains(customer)){
			session.put("custumer", customer);
		}
	
		
	}
		
	public CustomerDao getCustomerDao(){
		return new CustomerDao();
	}

	@Override
	public void setSession(Map<String, Object> session) {
				this.session = session;
	}
	
}

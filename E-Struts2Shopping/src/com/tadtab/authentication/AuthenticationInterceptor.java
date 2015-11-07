package com.tadtab.authentication;

import java.util.Map;

import main.StrutsAction.CustomerAction;
import main.java.Customer;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor{

	@Override
	public void destroy() {
				
	}

	@Override
	public void init() {
				
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Customer custumer = (Customer)session.get("custumer");
		
		if(custumer == null){
			
			return Action.INPUT;
			
		}else{
			
			Action action = (Action)invocation.getAction();
			
			if(action instanceof ActionAware){
				((ActionAware)action).setCustomer(custumer);
			}
			
		}
		return invocation.invoke();
	}
	
	public CustomerAction getCustomerAction(){
		return new CustomerAction();
	} 

}

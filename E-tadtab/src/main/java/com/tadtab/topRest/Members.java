package com.tadtab.topRest;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tadtab.top.Customer;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Members {
	@XmlElement(name="customer")
	private List<Customer> allMembers = new CopyOnWriteArrayList<Customer>();
	
	public List<Customer> getAllMembers() {
		return allMembers;
	}
	//
	//	
	//
	public void setAllMembers(List<Customer> allMembers) {
		this.allMembers = allMembers;
	}
	
	public void addAllMembers(Collection<Customer> members){
		allMembers.addAll(members);
	}
	
	// 
}

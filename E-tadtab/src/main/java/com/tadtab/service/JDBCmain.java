package com.tadtab.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCmain {
	public static void main(String[] args){
	ApplicationContext cxt = new AnnotationConfigApplicationContext(JDBCconfiguration.class);
	System.out.println("configurtion got called");
	JDBCservice ser = (JDBCservice) cxt.getBean(JDBCservice.class);
	System.out.println("Service class bean created!");
	ser.retrievePro(32768);
	}
}

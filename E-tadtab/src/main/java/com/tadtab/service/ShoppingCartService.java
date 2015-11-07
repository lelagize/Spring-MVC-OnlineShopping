package com.tadtab.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tadtab.top.Product;

public class ShoppingCartService {
	
	private ProductDao productDao;
	
	public ShoppingCartService(){}
	
	public ShoppingCartService(ProductDao productDao) {
		this.productDao = productDao;
	}

	// add a product to a cart
	// to do so create a list which is thread safe one, 
	// 
	
	public List<Product> prducts = new CopyOnWriteArrayList<Product>();
	
	public void addToCart(Integer productId){
		
		//  call the product dao method to retrive all products
		// and compare against the given id
		
		for (Product prdct : productDao.listOfProduct()){
			if(prdct.getProductId()==productId){
				prducts.add(prdct);
			}
		}		
		
	}
}

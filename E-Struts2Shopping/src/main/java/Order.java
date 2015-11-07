package main.java;

import java.io.Serializable;

public class Order implements Serializable {
	
	private Product product;
	private int quantity;

	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	public Order(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Order() {
		super();
		
	}
	
	

}

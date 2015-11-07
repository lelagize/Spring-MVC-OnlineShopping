package main.StrutsAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.Dao.ProductDao;
import main.java.Order;
import main.java.Product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartController extends ActionSupport {
	

	private int productId;
	List<Product> listOfProducts = new ArrayList<Product>();
	
	public int isProductIncart(int id){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<Order> cart = (List<Order>) session.get("cart");
		/*
		 * the cart has list of orders
		 *check if an order at index i has a product with productId w/c is equal to id
		 *
		 * */
		for(int i = 0; i < cart.size(); i++){
			if(cart.get(i).getProduct().getProductId() == id){
				return i;
			}
		}
		
		return -1;
	}
	
	public String execute(){
		placeOrder();
		removeOrder();
		return SUCCESS;
	}
	
				
	public void placeOrder(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("cart") == null){
			List<Order> cart = new ArrayList<Order>();
			
			Product productToCart = getProductDao().getAProduct(productId);
			Order orderdProduct = new Order (productToCart, 1);
			
			cart.add(orderdProduct);
		
			session.put("cart", cart);
			
		}else{
			
			int index = isProductIncart(productId);
			List<Order> cart = (List<Order>) session.get("cart");
			if(index == -1){	
				
				
				Product productToCart = getProductDao().getAProduct(productId);
				Order orderdProduct = new Order (productToCart, 1);
				
				cart.add(orderdProduct);
				session.put("cart", cart);
				
			}else{
				/*Order in the cart
				 * increment the quantity of the order by 1
				 * to do this
				 * find that order with this id from the cart
				 * and set the quantity  
				 * */
				Order order = cart.get(index);
				int quantity = order.getQuantity() + 1;
				order.setQuantity(quantity);
								
			}
		
			
		}
		
		
		
	}
	
	public void removeOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		getProductDao().removeAproduct(productId);
		listOfProducts = (List<Product>) getProductDao().listOfProduct();
		
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public ProductDao getProductDao(){
		return new ProductDao();
	}

	public List<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

}

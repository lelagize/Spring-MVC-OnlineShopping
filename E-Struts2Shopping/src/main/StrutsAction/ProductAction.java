package main.StrutsAction;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import main.Dao.ProductDao;
import main.java.Product;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
	
	public String execute(){
		setProducts(getProductDao().listOfProduct());
		/*firstProduct();*/
		return SUCCESS;
	}
	
	
	
	public void firstProduct(){
		for(Iterator it = products.iterator(); it.hasNext();){
			setProduct((Product) it.next());
			break;
		}
	}
	
	
	private Product product;		
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	private Collection products;
	
	
	public Collection getProducts() {
		return products;
	}


	public void setProducts(Collection products) {
		this.products = products;
	}


	public ProductDao getProductDao(){
		return new ProductDao();
		
	}
}


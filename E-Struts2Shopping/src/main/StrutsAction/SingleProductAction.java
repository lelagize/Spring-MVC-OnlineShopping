package main.StrutsAction;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;
import main.Dao.ProductDao;
import main.java.Product;

import com.opensymphony.xwork2.ActionSupport;

public class SingleProductAction extends ActionSupport{
	
	private int productId;
	private Product prdct;
	
	private static final Logger logger = Logger.getLogger(SingleProductAction.class);
	
	public String execute(){
		System.out.println(" = "  + productId);
		
		setPrdct(getProductDao().getAProduct(productId));
		
		/*List listofpr = (List)getProductDao().listOfProduct();
		Iterator it = listofpr.iterator();
		while(it.hasNext()){
			Product pr = (Product)it.next();
			if(pr.getProductId() == productId){
				setPrdct(pr);
			}
	}*/
		
 
		return "success";	
		
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public Product getPrdct() {
		return prdct;
	}

	public void setPrdct(Product prdct) {
		this.prdct = prdct;
	}

	public ProductDao getProductDao(){
		return new ProductDao();
	} 
}

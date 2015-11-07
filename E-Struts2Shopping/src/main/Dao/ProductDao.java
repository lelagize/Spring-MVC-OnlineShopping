package main.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;





import java.util.ListIterator;

import main.java.Product;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class ProductDao {
	
	private static Session session = null;
		
	public Collection listOfProduct(){
		List productList = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
			List query = session.createQuery("from Product").list();
			productList = query;
			
			
		session.getTransaction().commit();
		session.close();
		return productList;
		
	}
	
	public Product getAProduct(int productId){
		List listofpr = (List)listOfProduct();
		Product p = null;
		Iterator it = listofpr.iterator();
		while(it.hasNext()){
			Product pr = (Product)it.next();
			if(pr.getProductId() == productId){
				p = pr;
			}
		}
		
		return p;
	}
	
	public void removeAproduct(int id){
		ProductDao proDAO = new ProductDao();
		List listpro = (List)proDAO.listOfProduct();
		Iterator it = listpro.iterator();
		while(it.hasNext()){
			if(((Product)it.next()).getProductId() == id){
				it.remove();
			}
		}
	}
	
	public static void main(String[] args){
		
		ProductDao pd = new ProductDao();
		System.out.println(pd.listOfProduct());
	}
}

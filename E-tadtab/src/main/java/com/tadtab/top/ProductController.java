package com.tadtab.top;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tadtab.service.ProductDao;
import com.tadtab.top.Product;

@Controller
@RequestMapping("/")
public class ProductController {
	
	private ProductDao productDao;
	
	@Autowired
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//create a list to take the list of products returned
	//GET method will do the business logic
	
	List<Product> lst = java.util.Collections.emptyList();
	
	/*@RequestMapping(method = RequestMethod.GET )
	public void getlst(){}*/
	
	@RequestMapping(method = RequestMethod.GET )
	public String alist(Model model){
		
			lst = (List<Product>) productDao.listOfProduct();
			model.addAttribute("lst", lst);
		Date date = new Date();
		model.addAttribute("date", date);
		
		return "productQuery";
		
	} 
	
	

}

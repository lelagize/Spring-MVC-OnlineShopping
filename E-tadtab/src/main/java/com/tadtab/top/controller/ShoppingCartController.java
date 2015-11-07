package com.tadtab.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tadtab.service.ShoppingCartService;

@Controller
@RequestMapping("/addToCart*")
public class ShoppingCartController {
	
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	// add into a shopping cart
	// 
	/*@RequestMapping(method = RequestMethod.GET)
	public String addtoCart(@RequestParam(required=true, value="productId") Integer productId, Model model){
		shoppingCartService.addToCart(productId);
		return 
	}
*/
	
}

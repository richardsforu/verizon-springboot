package com.cts.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.entities.Product;
import com.cts.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@RequestMapping("hello")
	public String test() {
		
		Product prod=new Product();
		prod.setPrice(8384);
		prod.setProdId("P001");
		prod.setProdName("Laptop");
		
		System.out.println("---- test method of ProductController");
		prodService.persist(prod);
		
		return "info";
	}

}

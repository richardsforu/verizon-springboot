package com.cts.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

	@GetMapping("/s2")
	public String f1() {
		return "Welcome to s2 get mapping";
	}
	
	@PostMapping("/s2")
	public String f2() {
		return "Welcome to s2 post mapping";
	}
	
	@PutMapping("/s2")
	public String f3() {
		return "Welcome to s2 put mapping";
	}
	
	@DeleteMapping("/s2")
	public String f4() {
		return "Welcome to s2 delete mapping";
	}
	

	
	


}

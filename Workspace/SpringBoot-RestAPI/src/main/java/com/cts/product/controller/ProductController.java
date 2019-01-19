package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.entities.Product;
import com.cts.product.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService ps;

	// Product CRUD Operations

	// List All Products
	@GetMapping(value="/",produces = "application/json")
	public List<Product> listAll() {

		return ps.listAll();
	}

	// Find Product By Id
	@GetMapping("/{productId}")
	public Product findProduct(@PathVariable("productId") String pid) {

		return ps.findById(pid);
	}

	// Find Product By name
	@GetMapping("/name/{productName}")
	public List<Product> findProductByName(@PathVariable("productName") String pname) {

		return ps.readProductByProductLike("%" + pname + "%");
	}

	// save Product
	@PostMapping("/")
	public void saveProduct(@RequestBody Product prod) {

		ps.persist(prod);

	}

	// Update Product with ID

	@PutMapping("/")
	public void updateProduct(@RequestBody Product prod) {

		ps.persist(prod);

	}

	// Delete Product By Id
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") String pid) {
		ps.deleteProduct(pid);
	}

}

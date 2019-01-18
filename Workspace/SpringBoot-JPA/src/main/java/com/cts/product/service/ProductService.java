package com.cts.product.service;

import java.util.List;

import com.cts.product.entities.Product;

public interface ProductService {
	
	public void persist(Product prod);
	public Product findById(String prodId);
	public List<Product> listAll();

}

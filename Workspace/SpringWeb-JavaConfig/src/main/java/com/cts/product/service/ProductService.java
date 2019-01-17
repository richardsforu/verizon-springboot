package com.cts.product.service;

import com.cts.product.entities.Product;

public interface ProductService {
	
	public void persist(Product prod);
	public Product findById(String prodId);

}

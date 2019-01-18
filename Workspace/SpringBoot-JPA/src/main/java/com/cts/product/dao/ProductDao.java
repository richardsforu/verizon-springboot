package com.cts.product.dao;

import java.util.List;

import com.cts.product.entities.Product;

public interface ProductDao {
	
	public void saveProduct(Product prod);
	public Product find(String prodId);
	public List<Product> listAll();
	


}

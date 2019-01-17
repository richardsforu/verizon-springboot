package com.cts.product.dao;

import com.cts.product.entities.Product;

public interface ProductDao {
	
	public void saveProduct(Product prod);
	public Product find(String prodId);
	


}

package com.cts.product.dao;

import org.springframework.stereotype.Repository;

import com.cts.product.entities.Product;
@Repository("prodDao")
public class ProductDaoImpl implements ProductDao{

	public void saveProduct(Product prod) {
		System.out.println("Dao: Saving "+prod.getProdName());
	}

	public Product find(String prodId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
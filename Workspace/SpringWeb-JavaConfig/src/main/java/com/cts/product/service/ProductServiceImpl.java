package com.cts.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.entities.Product;

@Service("prodService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao prodDao;

	public void persist(Product prod) {
		
		prodDao.saveProduct(prod);
		
	}

	public Product findById(String prodId) {
		return prodDao.find(prodId);
	}

	
}

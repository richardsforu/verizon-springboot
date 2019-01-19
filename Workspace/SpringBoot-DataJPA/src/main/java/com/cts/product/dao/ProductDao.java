package com.cts.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.product.entities.Product;

public interface ProductDao extends JpaRepository<Product, String>{
	
	List<Product> readProductByProductNameIsLike(String productName);
	
	//@Query(value="select prod from Product as prod where prod.price > ?")
	//List<Product> findAllProductsByMaxPrice(double price);
	
}

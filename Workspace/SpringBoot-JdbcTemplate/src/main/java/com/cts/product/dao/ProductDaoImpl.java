package com.cts.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cts.product.entities.Product;
@Repository("prodDao")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private JdbcTemplate jt;
	

	public void saveProduct(Product prod) {
		String qry="update product set name='New Name' where id=?";
		jt.update(qry,"P001");
		System.out.println("Dao: Saving "+prod.getProdName());
	}

	public Product find(String prodId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}




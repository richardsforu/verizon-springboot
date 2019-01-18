package com.cts.product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;
import com.cts.product.entities.Product;

@Repository("prodDao")
@Transactional()
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	public void saveProduct(Product prod) {
		em.persist(prod);

	}

	public List<Product> listAll() {

		Query qry = em.createNamedQuery("lp");
		
		

		return qry.getResultList();
	}

	public Product find(String prodId) {

		return em.find(Product.class, prodId);
	}

}

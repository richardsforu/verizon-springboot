package com.cts.product.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQuery(name="lp",query="select prod from com.cts.product.entities.Product as prod")
public class Product {

	@Id
	//@Column(name="id")
	private String productId;
	private String productName;
	private double price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

package com.pricematrix;

import org.springframework.stereotype.Repository;

// Dependency
@Repository("price")
public class PriceMatrixImpl implements PriceMatrix {

	public PriceMatrixImpl() {
		System.out.println("---- PriceMatrix Object created...");
	}

	public double getItemPrice(String itemCode) {

		// fetch itemPrice from DB

		return 100.00;
	}

}

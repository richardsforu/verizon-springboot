package com.pricematrix;
// Dependency
public class PriceMatrixImpl implements PriceMatrix {

	public PriceMatrixImpl() {
		System.out.println("---- PriceMatrix Object created...");
	}

	@Override
	public double getItemPrice(String itemCode) {

		// fetch itemPrice from DB

		return 100.00;
	}

}

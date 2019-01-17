package com.pricematrix;

import org.springframework.stereotype.Repository;

@Repository("c1")
public class C1 implements PriceMatrix{
	public double getItemPrice(String itemCode) {

		return 200;
	}

}

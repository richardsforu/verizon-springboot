package com.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pricematrix.PriceMatrix;
import com.pricematrix.PriceMatrixImpl;

//Dependent
@Service("bill")
public class BillingImpl {
	
	public BillingImpl() {

		System.out.println("--- billingImpl");
	}
	
	/*
	 * Design Issues
	 * ------------------
	 * 1. Too many dependency class objects.
	 * 		--> Per appl goes down
	 * 		--> memory issues
	 * 
	 * Why this issue happened?
	 * ----------------------------
	 * -> Dependent class is creating dependency class obj
	 * 
	 * What is the Solution?
	 * -----------------------
	 * -> DO not create dependency in the dependent class.
	 * 
	 * -> Use JNDI look up technique to look up for the dependency objs 
	 * 	-> Loc of JNDI is tightly coupled with Depencent class obj.
	 * 
	 * What is teh best solution?
	 * ---------------------------
	 * 
	 * -> Do not create, Do not find it, insted ask one one.  (IoC)
	 * 
	 * ioC
	 * ------
	 * -> setter based injection
	 * -> constructor based injection
	 * 
	 */
	
	@Autowired
	@Qualifier(value="c1")
	private PriceMatrix price;
	

	public double getCartTotal(String[] cart) {

		double total = 0.0;
		//PriceMatrix price = new PriceMatrixImpl();

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}

		return total;
	}

}

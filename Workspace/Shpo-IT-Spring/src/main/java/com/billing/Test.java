package com.billing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pricematrix.PriceMatrix;
import com.pricematrix.PriceMatrixImpl;

public class Test {

	public static void main(String[] args) {

		String[] cart1 = { "P001", "P002", "P003" };
		String[] cart2 = { "P001", "P002" };
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		
		BillingImpl bill=ac.getBean(BillingImpl.class);
		
		//-----------------------------
		//PriceMatrix price=new PriceMatrixImpl(); // Dependency
		
		//--------------------------------
		
		//BillingImpl bill = new BillingImpl(); // Dependent
		
		//bill.setPrice(price); // DI
		
		
		double total = bill.getCartTotal(cart1);

		System.out.println("--- Cart1 Total v1: " + total);

		total = bill.getCartTotal(cart2);

		System.out.println("--- Cart2 Total v1: " + total);
	}

}

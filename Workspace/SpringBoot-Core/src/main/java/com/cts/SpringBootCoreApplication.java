package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.BankService;
import com.cts.service.ProductService;

@SpringBootApplication
@ComponentScan("com")
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		System.out.println("--- Testing...");
		ApplicationContext ac= SpringApplication.run(SpringBootCoreApplication.class, args);
		ac.getBean(EmployeeService.class).test();
		ac.getBean(ProductService.class).productTest();
		ac.getBean(BankService.class).bankTest();
	}

}


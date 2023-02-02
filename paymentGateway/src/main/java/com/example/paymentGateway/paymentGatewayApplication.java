package com.example.paymentGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class paymentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(paymentGatewayApplication.class, args);
		System.out.println("The Payment Gateway is running.............");
	}

}

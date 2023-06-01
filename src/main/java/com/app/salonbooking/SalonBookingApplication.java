package com.app.salonbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SalonBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonBookingApplication.class, args);
	}

}

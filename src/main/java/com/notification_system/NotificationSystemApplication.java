package com.notification_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ye class poore Spring Boot application ka entry point hai.
 *
 * @SpringBootApplication annotation teen cheeze internally enable karta hai:
 * 1. @Configuration      - Batata hai ki ye class configuration ke liye use hogi
 * 2. @EnableAutoConfiguration - Spring Boot ko auto setup karne deta hai
 * 3. @ComponentScan      - Automatically same package aur niche ke sab beans scan karta hai
 */
@SpringBootApplication
public class NotificationSystemApplication {

	/**
	 * Main method se Spring Boot app start hoti hai.
	 * Ye embedded server (like Tomcat) ko start karta hai aur application context load karta hai.
	 *
	 * @param args Command line arguments (generally blank in local dev)
	 */
	public static void main(String[] args) {
		SpringApplication.run(NotificationSystemApplication.class, args);
	}
}

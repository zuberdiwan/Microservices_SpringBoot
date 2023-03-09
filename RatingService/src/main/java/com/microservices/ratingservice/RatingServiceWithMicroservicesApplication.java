package com.microservices.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceWithMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceWithMicroservicesApplication.class, args);
	}

}

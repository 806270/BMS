package com.cts.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.cts.bms.repository")
@SpringBootApplication
public class BmsLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsLoanApplication.class, args);
	}
  
} 
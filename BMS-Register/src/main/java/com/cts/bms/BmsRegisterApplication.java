package com.cts.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.cts.bms.service.WebLoanService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.cts.bms.repository")
@SpringBootApplication
public class BmsRegisterApplication {
	private static final Logger log = LogManager.getLogger(BmsRegisterApplication.class);
	public static void main(String[] args) {
		 log.info("Bms Registration application starts");
		SpringApplication.run(BmsRegisterApplication.class, args);
	}
	  
	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    } 
	
	@Bean
	WebLoanService loanService()
	{
		return new WebLoanService();
	}   
	
}
 
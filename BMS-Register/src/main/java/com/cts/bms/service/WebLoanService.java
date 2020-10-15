package com.cts.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebLoanService {
	
	
	@Autowired
    private RestTemplate restTemplate;
 
    private String serviceUrl;
	
	public WebLoanService() {
		this.serviceUrl = "http://bmsloan";
	}

	    
		
		  public String loan( Object loan) 
		  { 
			  
		   System.out.println("calling loan service:" +this.serviceUrl);			
		  return restTemplate.getForObject("http://bmsloan/bmsloan/test", String.class);  
		   
		  // return restTemplate.getForObject("http://localhost:3333/bmsloan/test", String.class);
		   
		
		  }
		 

}

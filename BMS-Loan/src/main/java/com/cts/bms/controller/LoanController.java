package com.cts.bms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cts.bms.model.Loan;
import com.cts.bms.repository.LoanRepo;

@RestController
@RequestMapping(value = "/bmsloan/")
public class LoanController { 
	
		@Autowired
		LoanRepo loanrepository ;
	
	    @PostMapping(value = "/loan")
	    public String loan(@RequestBody final Loan user) {
			 
		  loanrepository.save(user);
		  return "Loan details submitted successfully!";
	    }
	    
	    @GetMapping(value = "/fetchall")
		public List<Loan> read() { 

			return loanrepository.findAll();

		}
	    
		@GetMapping(value = "/fetch")
		public Optional<Loan> read(@RequestParam(value = "username", required = true) String user) {

			return loanrepository.findById(user);

		}
		
		@DeleteMapping(value = "/delete")
		public void delete(@RequestParam(value = "username", required = true) String user) {

			loanrepository.deleteById(user);
	 
		}
		
	    
	    @GetMapping(value = "/test")
	    public String test()
	    {
	    	return "success";
	    }

}

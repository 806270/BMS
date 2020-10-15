package com.cts.bms.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bms.model.AccountRegistration;
import com.cts.bms.repository.AccountRegistrationRepository;
import com.cts.bms.service.WebLoanService;


@RestController
@RequestMapping(value = "/bmsregister/")
public class AccountRegistrationController {

	private static final Logger log = LogManager.getLogger(AccountRegistrationController.class);
	
	@Autowired
	AccountRegistrationRepository accountRegistrationRepository;

	@Autowired
	WebLoanService loanService;

	@PostMapping(value = "/register")
	public String create(@RequestBody final AccountRegistration users) {

		
		boolean exist = accountRegistrationRepository.existsById(users.getUserName());
		log.info("Given user exist is: {}", exist);
		log.debug("Given user exist is: {}", exist);
		
		if (!exist) {
			accountRegistrationRepository.save(users);
			return "User has been registered succesfully!";
			
		} else
			return "User already registered!";
	}
    
	//@Cacheable(value = "users" , key = "#user.id") 
	@GetMapping(value = "/fetchall")
	public List<AccountRegistration> read() {  
		 
		log.info("read all data");
		return accountRegistrationRepository.findAll();

	} 

	@Cacheable(value = "users" , key = "#userName") 
	@GetMapping(value = "/fetch") 
	public Optional<AccountRegistration> read(@RequestParam(value = "username", required = true) String user) {
		
		log.info("Fetch user: {}", user);
		return accountRegistrationRepository.findById(user);

	} 

	@PutMapping(value = "/update")
	public String update(@RequestBody final AccountRegistration users) {

		boolean exist = accountRegistrationRepository.existsById(users.getUserName());
		if (exist) {
			accountRegistrationRepository.save(users);
			return "Provided details are updated succesfully!";
		} else
			return "User not found! Please register!";
	}

	
	@DeleteMapping(value = "/delete")
	public void delete(@RequestParam(value = "username", required = true) String user) {

		accountRegistrationRepository.deleteById(user);
 
	}

	@PostMapping(value = "/loan")
	public String userExist(@RequestBody final Object loanDetail) {

		System.out.println(loanDetail);
		String returnValue = loanService.loan(loanDetail);
		return returnValue;
	}

}

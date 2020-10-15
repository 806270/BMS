package com.cts.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bms.model.AccountRegistration;


public interface AccountRegistrationRepository extends JpaRepository<AccountRegistration, String> {

}

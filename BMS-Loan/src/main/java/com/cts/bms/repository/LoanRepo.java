package com.cts.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bms.model.Loan;

public interface LoanRepo  extends JpaRepository<Loan, String>{ 

}

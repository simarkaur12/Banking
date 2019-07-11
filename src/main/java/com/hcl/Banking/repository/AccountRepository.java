package com.hcl.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Banking.entity.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
 public Account findByUserNumber(Long id);
 public Account findByAccountNumber(Long accountNumber);
}

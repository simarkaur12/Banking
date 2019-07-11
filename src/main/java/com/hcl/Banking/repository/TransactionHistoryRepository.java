package com.hcl.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Banking.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long>{

}

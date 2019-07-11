package com.hcl.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Banking.entity.FundTranfer;

@Repository
public interface FundtransferRepository extends JpaRepository<FundTranfer, Long>{

}

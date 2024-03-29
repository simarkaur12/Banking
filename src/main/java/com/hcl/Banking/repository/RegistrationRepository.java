package com.hcl.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Banking.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}

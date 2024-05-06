package com.businesss.businessJpa.dao;

import com.businesss.businessJpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}

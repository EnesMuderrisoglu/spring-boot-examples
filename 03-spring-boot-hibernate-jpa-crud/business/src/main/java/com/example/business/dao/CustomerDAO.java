package com.example.business.dao;
import java.util.List;

import com.example.business.entity.Customer;
import com.example.business.entity.Product;
import org.hibernate.sql.Delete;

import java.util.List;

public interface CustomerDAO {

    void save(Customer theCustomer);

    Customer findById(Integer id);

    List<Customer> findAll();

    List<Customer> findByLastName(String theLastName);

    void update(Customer theCustomer);

    void delete(Integer id);

    int deleteAll();
}

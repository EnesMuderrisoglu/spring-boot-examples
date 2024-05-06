package com.example.business.dao;
import java.util.List;

import com.example.business.entity.Customer;
import com.example.business.entity.Product;
import jakarta.transaction.Transactional;


public interface ProductDAO {

     void save(Product theProduct);

     Product findById(Integer id);

     List<Product> findAll();
     List<Product> findByLastOrigin(String theOrigin);

     void update(Product theProduct);
     void delete(Integer id);

     int deleteAll();

}



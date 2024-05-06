package com.example.business.dao.ımpl;

import com.example.business.dao.CustomerDAO;
import com.example.business.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //entity manager
    @Autowired
    private EntityManager entityManager;

    //injection with constructor
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        entityManager.persist(theCustomer);// saves the student
    }

    @Override
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public List<Customer> findAll() {

        TypedQuery<Customer> theQuery = entityManager.createQuery("FROM Customer  ",Customer.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Customer> findByLastName(String theLastName) {
        TypedQuery<Customer> theQuery = entityManager.createQuery("FROM Customer WHERE lastName=:theData",Customer.class);
        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Customer theCustomer) {
        entityManager.merge(theCustomer);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Customer theCustomer = entityManager.find(Customer.class,   id);
        entityManager.remove(theCustomer);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete FROM Customer ").executeUpdate();
        return numRowsDeleted;
    }
}

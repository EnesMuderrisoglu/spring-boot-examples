package com.example.business.dao.ımpl;

import com.example.business.dao.ProductDAO;
import com.example.business.entity.Customer;
import com.example.business.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    //entity manager
    private EntityManager entityManager;

    //injection

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //

    @Override
    @Transactional
    public void save(Product theProduct){
        entityManager.persist(theProduct);
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findAll() {

        TypedQuery<Product> theQuery = entityManager.createQuery("FROM Product order by price desc",Product.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Product> findByLastOrigin(String theOrigin) {
        TypedQuery<Product> theQuery = entityManager.createQuery("FROM Product WHERE origin=: theData",Product.class);
        theQuery.setParameter("theData",theOrigin);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Product theProduct) {
        entityManager.merge(theProduct);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Product theProduct = entityManager.find(Product.class,id);
        entityManager.remove(theProduct);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete FROM Product ").executeUpdate();
        return numRowsDeleted;
    }
}

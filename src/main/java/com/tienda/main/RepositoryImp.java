package com.tienda.main;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.model.ProductModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Repository
@Transactional
public class RepositoryImp {
    
    @PersistenceContext
    private EntityManager eManager;


    public List<ProductModel> getProduct(){
        String query=" from ProductModel";
        return eManager.createQuery(query).getResultList();
    }

}

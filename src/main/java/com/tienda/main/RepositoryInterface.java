package com.tienda.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.model.ProductModel;
@Repository
@Transactional
public interface RepositoryInterface extends JpaRepository<ProductModel, Integer>{
    
}

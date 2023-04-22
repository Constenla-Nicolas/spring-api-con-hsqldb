package com.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tienda.main.RepositoryInterface;
import com.tienda.model.ProductModel;
@Service
public class ProductService {
    @Autowired
  private RepositoryInterface rInterface;
   
    public List<ProductModel> getProduct(){
        return (List<ProductModel>) rInterface.findAll();
        
    }

    public void addNewProduct(ProductModel product) {
        rInterface.save(product);
       
    }

    public void deleteProduct(int id) {
       if (!rInterface.existsById(id)) {
        throw new IllegalStateException("no existe producto con id "+id);
       }
        rInterface.deleteById(id);
    }
}

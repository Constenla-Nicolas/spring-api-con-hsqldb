package com.tienda.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tienda.main.RepositoryInterface;
import com.tienda.model.ProductModel;

import jakarta.transaction.Transactional;
@Service
public class ProductService {
    @Autowired
  private RepositoryInterface rInterface;
   
    public List<ProductModel> getProducts(){
        return  rInterface.findAll();
        
    }
 
    
    public void addNewProduct(ProductModel product) {
        rInterface.save(product);
       
    }
    @Transactional
    public void updateProduct(int id,String name, String description, int amount, int price){
        
       if(!rInterface.existsById(id)){
        throw new IllegalStateException("no existe producto con id "+id);
       }
       ProductModel tempProduct=rInterface.findById(id).get();
       if (name!=null && name.length()>0) {tempProduct.setName(name);}
       if (description!=null && name.length()>0) {tempProduct.setDescription(description);}
       if (amount>-1) {tempProduct.setAmount(amount);}
       if (price>-1) {tempProduct.setPrice(price);}
       rInterface.save(tempProduct);

    }
    public void deleteProduct(int id) {
    //    if (!rInterface.existsById(id)) {
    //     throw new IllegalStateException("no existe producto con id "+id);
    //    }
        rInterface.deleteById(id);
    }

    public List<ProductModel> getProductbyName(String name) {
        return List.of(rInterface.findByName(name));
        // return List.of(rInterface.findById(name).orElseThrow(() -> new IllegalStateException("no existe producto con el id "+id)));
    }

    public List<ProductModel> getProductbyId(int id) {
        return List.of(rInterface.findById(id).orElseThrow(() -> new IllegalStateException("no existe producto con el id "+id)));
    }
    
}

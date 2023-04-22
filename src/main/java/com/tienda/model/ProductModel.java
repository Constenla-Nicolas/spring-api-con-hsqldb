package com.tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

@Entity
@Table(name="PRODUCTO")
public class ProductModel {
    private int id;   
    private String name;
    private String description;
    private int price;
    private int amount;
   
    public ProductModel(){}
    // public ProductModel(int id,String name, String description,int price, int amount){
    //     this.id=id;
    //     this.price=price;
    //     this.amount=amount;
    //     this.name=name;
    //     this.description=description;
        
    // }
//.
    
public ProductModel(String name, String description,int price, int amount){
    this.price=price;
    this.amount=amount;
    this.name=name;
    this.description=description;
}
    @Id
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public int getAmount() {
        return amount;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    

 


}

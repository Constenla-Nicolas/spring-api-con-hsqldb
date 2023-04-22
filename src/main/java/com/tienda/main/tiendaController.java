package com.tienda.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tienda.model.ProductModel;
import com.tienda.service.ProductService;

@RestController

public class tiendaController {
    
    
  @Autowired
  private  ProductService productService;
  @Autowired RepositoryImp repositoryImp;
 

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductModel> hello(){
        return List.of(
            new ProductModel("maaaaaaa", "potooooooooo  ", 12, 1)
        );
    }

    @RequestMapping(value = "/api/get/RepositoryInterface", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductModel> getProductModel(){
        return productService.getProduct();
    }
    @RequestMapping(value = "/api/get/DAOImp", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductModel> getProductModels(){
        return repositoryImp.getProduct();
    }
    @RequestMapping(value ="/api/post", method =  RequestMethod.POST)
    public void registerProduct(@RequestBody ProductModel product){
      productService.addNewProduct(product);
    }
    // @RequestMapping(value = "/api", method   = RequestMethod.DELETE, path= "{productId}")
    // public void deleteProduct(@PathVariable("productId")int id){
    //   productService.deleteProduct(id);
    // }
}

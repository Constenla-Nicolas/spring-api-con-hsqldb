package com.tienda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.tienda.model.ProductModel;
import com.tienda.service.ProductService;

@RestController

public class tiendaController {
    
    
  @Autowired
  private  ProductService productService;
 
 

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public List<String> hello() throws SQLException, ClassNotFoundException{
    //     Class.forName("org.hsqldb.jdbc.JDBCDriver");
    //     Connection conn = DriverManager.getConnection(
    //                          "jdbc:hsqldb:mem:mydb", "SA", "1234");
 
    //     Statement st = conn.createStatement();
   
    //     String sql = "SELECT * FROM INFORMATION_SCHEMA.SYSTEM_TABLES where TABLE_NAME='PRODUCTO' ";
    //     System.out.println(st.executeQuery(sql));



    //     DatabaseMetaData md = conn.getMetaData();
    // ResultSet rs = md.getTables(null, null, "%", null);
    // List<String> listaStrings= new ArrayList<String>();
    // while (rs.next()) {
    // listaStrings.add(rs.getString(3));}
    //     return listaStrings;
    // }

    @RequestMapping(value = "/api/get", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductModel> getAllProducts(){
        return productService.getProducts();
    }

    @RequestMapping(value = "/api/getProduct/{productId}", method = RequestMethod.GET)
    public List<ProductModel> getProductById(@PathVariable("productId") String id){
    
        try {
           int tempid= Integer.parseInt(id);
           System.out.println("tempid "+ tempid);
            return productService.getProductbyId(tempid);
        } catch (Exception e) {
            return productService.getProductbyName(id);
        }
      
    }
  
 
    
    @RequestMapping(path="api/put/{productId}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("productid") int id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String description,
                              @RequestParam(required = false) int price,
                              @RequestParam(required = false) int amount){
                try {
                    productService.updateProduct(id, name, description, amount, price);
                } catch (Exception e) {
                  
                    e.printStackTrace();
                }
    }
   
    @RequestMapping(value ="/api/post", method =  RequestMethod.POST)
    public void  registerProduct(@RequestBody ProductModel product){
        productService.addNewProduct(product);
    }
 
    @DeleteMapping(path= "api/delete/{productId}")
    public void deleteProduct(@PathVariable("productId")int id){
      productService.deleteProduct(id);
    }
        
    
    
}

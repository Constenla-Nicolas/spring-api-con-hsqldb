package com.tienda.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.model.ProductModel;
@EntityScan("com.tienda.model")   
@SpringBootApplication(scanBasePackages={
	"com.tienda", "com.tienda.main.MainApplication"})
 
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
 
}

package com.Productos.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.ProductModel;
@EntityScan("com.Productos.model")   
@SpringBootApplication(scanBasePackages={
	"com.Productos", "com.Productos.main.MainApplication"})
 
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
 
}

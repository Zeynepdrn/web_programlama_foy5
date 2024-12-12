package com.example.springmvc_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringmvcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcCrudApplication.class, args);
	}

}

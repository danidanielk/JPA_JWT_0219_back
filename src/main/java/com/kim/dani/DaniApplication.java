package com.kim.dani;

import com.kim.dani.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaniApplication.class, args);



	}

}

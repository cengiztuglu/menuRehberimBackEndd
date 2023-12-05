package com.example.menuRehberim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MenuRehberimApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuRehberimApplication.class, args);
	}

}

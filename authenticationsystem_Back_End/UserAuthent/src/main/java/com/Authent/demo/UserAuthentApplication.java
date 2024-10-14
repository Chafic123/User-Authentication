package com.Authent.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.Authent.*")
@EnableJpaRepositories(basePackages ="com.Authent.*")
@EntityScan("com.Authent.*")
public class UserAuthentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthentApplication.class, args);
	}

}

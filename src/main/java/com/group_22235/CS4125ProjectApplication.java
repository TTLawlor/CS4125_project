package com.group_22235;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CS4125ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CS4125ProjectApplication.class, args);
	}

}

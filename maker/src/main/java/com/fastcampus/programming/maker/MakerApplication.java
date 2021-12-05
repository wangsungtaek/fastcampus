package com.fastcampus.programming.maker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakerApplication.class, args);
	}

}

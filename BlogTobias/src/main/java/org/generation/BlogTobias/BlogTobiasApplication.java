package org.generation.BlogTobias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "org.generation.BlogTobias.model.java")
@SpringBootApplication
public class BlogTobiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogTobiasApplication.class, args);
	}

}
	
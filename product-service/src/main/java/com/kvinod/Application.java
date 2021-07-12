package com.kvinod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class Application {

	@GetMapping("/api/products/info")
	public String info() {
		return "product-service is here";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

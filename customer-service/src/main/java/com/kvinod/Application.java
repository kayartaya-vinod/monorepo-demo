package com.kvinod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;
import java.util.HashMap;

@RestController
@SpringBootApplication
public class Application {

	@GetMapping("/api/customers/info")
	public Map<String, Object> info() {
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Customer Service is here");
		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

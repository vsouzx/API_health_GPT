package br.com.souza.healthGPT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HealthGptApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthGptApplication.class, args);
	}

}

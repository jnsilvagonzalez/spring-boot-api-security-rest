package com.product.backend.apirest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.product.backend.apirest.models.entity.Role;
import com.product.backend.apirest.models.entity.User;
import com.product.backend.apirest.models.services.UserService;

@SpringBootApplication
public class SpringBootApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiRestApplication.class, args);
	}

	/**
	 * Methos used for set User and Password for generate Token
	 * 
	 * @param service
	 * @return
	 */
	@Bean
	public CommandLineRunner setupDefaultUser(UserService service) {
		return args -> {
			service.save(new User("user", "password", Arrays.asList(new Role("USER"), new Role("ACTUATOR")), true));
		};
	}

}

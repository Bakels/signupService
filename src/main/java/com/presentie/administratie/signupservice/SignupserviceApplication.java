package com.presentie.administratie.signupservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SignupserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignupserviceApplication.class, args);
	}

	@Bean
	public Queue status(){
		return new Queue("status");
	}

	@Bean
	public ObjectMapper mapper(){
		return new ObjectMapper();
	}
}

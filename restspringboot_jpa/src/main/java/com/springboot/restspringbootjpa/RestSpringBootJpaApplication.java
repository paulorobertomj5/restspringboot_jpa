package com.springboot.restspringbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.springboot.restspringbootjpa"})
@EnableAutoConfiguration
public class RestSpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSpringBootJpaApplication.class, args);
	}

}

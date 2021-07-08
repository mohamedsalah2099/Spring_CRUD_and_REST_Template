package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class CrudApplication{
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}

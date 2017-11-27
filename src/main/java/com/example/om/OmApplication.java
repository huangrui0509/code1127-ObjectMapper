package com.example.om;


import java.io.IOException;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.om.pojo.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ConfigurableApplicationContext context = SpringApplication.run(OmApplication.class, args);
		ObjectMapper objectMapper = (ObjectMapper)context.getBean(ObjectMapper.class);
		System.out.println(objectMapper);
		
		Person p = test();
		//person->json
		String personToJson= objectMapper.writeValueAsString(p);
		System.out.println(personToJson);
	
		
		//json->person
		Person jsonToPerson = objectMapper.readValue(personToJson, Person.class);
		System.out.println(jsonToPerson);
		
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
		
	}
	public static Person test() {
		Person p = new Person("huangrui",22);
		return p;
		 
	}
	
	
}

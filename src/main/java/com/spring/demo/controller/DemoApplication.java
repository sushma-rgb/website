package com.spring.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.demo.model.Users;
import com.spring.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController

@RequestMapping("user")
public class DemoApplication {
	@Autowired
	Userservice userservice;

		@GetMapping("allUsers")
		public List<Users> getAllUser(){
			return userservice.getAllUser();
		}
		@GetMapping("common_student")
		public String getDataFromAPI() {
			String data = userservice.getDataFromAPI();
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode rootNode = mapper.readTree(data);
				JsonNode dataNode = rootNode.get("data");

				if (dataNode != null && dataNode.isArray() && dataNode.size() > 0) {
					JsonNode firstObject = dataNode.get(0);
					String name = firstObject.get("name").asText();
					return name;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null ;
		}



}

package com.spring.demo.controller;

import com.spring.demo.model.User;
import com.spring.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class DemoApplication {
	@Autowired
Userservice userservice;
		@GetMapping("allUsers")
public List<User> getAllUser(){
	return userservice.getAllUser();
		}



}

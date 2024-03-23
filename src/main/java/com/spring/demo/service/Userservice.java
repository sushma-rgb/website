package com.spring.demo.service;

import com.spring.demo.dao.UserDao;
import com.spring.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
@Service
public class Userservice {
    @Autowired
    UserDao userDao;
    public List<Users> getAllUser(){
       return userDao.findAll();
    }

    @Autowired
    public RestTemplate restTemplate;
    public String getDataFromAPI() {
        String apiUrl = "https://commondata.qspiders.com/api/v1/student";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        return response.getBody();
    }

}

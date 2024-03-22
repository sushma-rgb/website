package com.spring.demo.service;

import com.spring.demo.dao.UserDao;
import com.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Userservice {
    @Autowired
    UserDao userDao;
    public List<User> getAllUser(){
       return userDao.findAll();
    }

}

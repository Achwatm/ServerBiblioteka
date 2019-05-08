package com.example.demo.controller;


import com.example.demo.dao.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {


    @Autowired
    UsersRepository usersRepository;



    //Add new user
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public List<Users> addNewUser(@RequestBody final Users users){
        usersRepository.save(users);
        return usersRepository.findAll();
    }

}

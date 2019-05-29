package com.example.demo.controller;


import com.example.demo.dao.Books;
import com.example.demo.dao.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {


    @Autowired
    UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showUsers",method = RequestMethod.GET)
    public List<Users> getBooks(){

        return usersRepository.showUsers();
    }


    //Add new user
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public List<Users> addNewUser(@RequestBody final Users users){
        usersRepository.save(users);
        return usersRepository.findAll();
    }

}

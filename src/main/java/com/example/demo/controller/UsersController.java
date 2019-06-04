package com.example.demo.controller;


import com.example.demo.dao.Authors;
import com.example.demo.dao.Books;
import com.example.demo.dao.Users;
import com.example.demo.dto.AuthorsDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addReaders",method = RequestMethod.POST)
    public ResponseEntity addReaders(@RequestBody final UsersDto usersDto){
        Users users = new Users(usersDto.getName(),usersDto.getLastName(),usersDto.getPesel(), usersDto.geteMail(),usersDto.getPassword(),usersDto.getAddress());
        usersRepository.save(users);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @RequestMapping(value ="/addAuthors",method = RequestMethod.POST)
//    public ResponseEntity addAuthors(@RequestBody final AuthorsDto authorsDto){
//        Authors authors = new Authors(authorsDto.getName(),authorsDto.getLastName());
//        authorsRepository.save(authors);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}

package com.example.demo.controller;

import com.example.demo.dao.Authors;
import com.example.demo.dto.AuthorsDto;
import com.example.demo.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showAuthors",method = RequestMethod.GET)
    public List<Authors> getAuthors(){

        return authorsRepository.showAuthors();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addAuthor",method = RequestMethod.POST)
    public ResponseEntity  addNewBook(@RequestBody final AuthorsDto authorsDto){
        Authors book = new Authors(authorsDto.getName(),authorsDto.getLastName());
        authorsRepository.save(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

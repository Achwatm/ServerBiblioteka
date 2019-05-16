package com.example.demo.controller;



import com.example.demo.dao.Books;
import com.example.demo.dto.BooksDto;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class BooksController {


    final
    BooksRepository booksRepository;


    @Autowired
    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showBooks",method = RequestMethod.GET)
    public List<Books> getBooks(){

        return booksRepository.showBooks();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addBook",method = RequestMethod.POST)
    public ResponseEntity  addNewPatient(@RequestBody final BooksDto booksDto){
        Books book = new Books(booksDto.getTitle(),booksDto.getDescription(),booksDto.getType(),booksDto.getIdAuthor());
        booksRepository.save(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}

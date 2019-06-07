package com.example.demo.controller;

import com.example.demo.dao.Books;
import com.example.demo.dao.Reserwations;
import com.example.demo.dao.Users;
import com.example.demo.dto.ReserwationsDto;
import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.BooksRepository;
import com.example.demo.repository.ReserwationsRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationsController {

    final
    ReserwationsRepository reserwationsRepository;
    UsersRepository usersRepository;
    BooksRepository booksRepository;
    @Autowired
    public ReservationsController(ReserwationsRepository reserwationsRepository, UsersRepository usersRepository, BooksRepository booksRepository) {
        this.reserwationsRepository = reserwationsRepository;
        this.usersRepository = usersRepository;
        this.booksRepository = booksRepository;

    }
    public Users user(int id){
        Users user = new Users();
        for (Users users : usersRepository.showUsers()) {
            if (users.getIdUser().equals(id)) {
                user = users;
                break;
            }
        }
        return user;
    }
    public Books book(int id){
        Books book = new Books();
        for (Books books : booksRepository.showBooks()) {
            if (books.getIdBook().equals(id)) {
                book = books;
                break;
            }
        }
        return book;
    }






    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showReservations",method = RequestMethod.GET)
    public List<Reserwations> getReservations(){

        return reserwationsRepository.showReservations();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/makeReservation",method = RequestMethod.POST)
    public ResponseEntity makeReservation(@RequestBody final ReserwationsDto reserwationsDto){

        Reserwations book = new Reserwations(reserwationsDto.getDateReserwation(),user(reserwationsDto.getIdUser()),book(reserwationsDto.getIdBook()));

        reserwationsRepository.save(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

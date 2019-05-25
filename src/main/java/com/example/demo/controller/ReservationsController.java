package com.example.demo.controller;

import com.example.demo.dao.Books;
import com.example.demo.dao.Reserwations;
import com.example.demo.dto.ReserwationsDto;
import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.BooksRepository;
import com.example.demo.repository.ReserwationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationsController {

    final
    ReserwationsRepository reserwationsRepository;

    @Autowired
    public ReservationsController(ReserwationsRepository reserwationsRepository) {
        this.reserwationsRepository = reserwationsRepository;
    }







    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showReservations",method = RequestMethod.GET)
    public List<Reserwations> getReservations(){

        return reserwationsRepository.showReservations();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/makeReservation",method = RequestMethod.POST)
    public ResponseEntity makeReservation(@RequestBody final ReserwationsDto reserwationsDto){

        Reserwations book = new Reserwations(reserwationsDto.getDateReserwation(), reserwationsDto.getIdUser(),reserwationsDto.getIdBook());

        reserwationsRepository.save(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

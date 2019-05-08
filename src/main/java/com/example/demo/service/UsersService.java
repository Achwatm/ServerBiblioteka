package com.example.demo.service;

import com.example.demo.repository.UsersRepository;

import com.example.demo.dao.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService   {
    @Autowired
    UsersRepository usersRepository ;

    public boolean checkPassword(String passwordFirst, String passwordSecond){
        if(passwordFirst.equals(passwordSecond)){
            return true;
        }
        return false;
    }

    public void addNewUser(Users customer){
        usersRepository.save(customer);
    }



}

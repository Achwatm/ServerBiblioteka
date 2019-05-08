package com.example.demo.dto;



import javax.persistence.*;


public class UsersDto {

    private String name;
    private String lastName;
    private String pesel;
    private String eMail;
    private String password;
    private String address;

    public UsersDto() {
    }

    public UsersDto(String name, String lastName, String pesel, String eMail, String password, String address) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.eMail = eMail;
        this.password = password;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

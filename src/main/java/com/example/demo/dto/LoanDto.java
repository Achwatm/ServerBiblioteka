package com.example.demo.dto;


import com.example.demo.dao.Copy;
import com.example.demo.dao.Users;

import java.util.Date;

public class LoanDto {


    private Date dataLoan;
    private Date dataReturn;
    private Users idUser;
    private Copy idCopy;

    public LoanDto() {
    }

    public LoanDto(Date dataLoan, Date dataReturn, Users idUser, Copy idCopy) {
        this.dataLoan = dataLoan;
        this.dataReturn = dataReturn;
        this.idUser = idUser;
        this.idCopy = idCopy;
    }


    public Date getDataLoan() {
        return dataLoan;
    }

    public void setDataLoan(Date dataLoan) {
        this.dataLoan = dataLoan;
    }

    public Date getDataReturn() {
        return dataReturn;
    }

    public void setDataReturn(Date dataReturn) {
        this.dataReturn = dataReturn;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Copy getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Copy idCopy) {
        this.idCopy = idCopy;
    }
}
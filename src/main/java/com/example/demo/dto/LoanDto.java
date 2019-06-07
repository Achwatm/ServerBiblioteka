package com.example.demo.dto;


import com.example.demo.dao.Copy;
import com.example.demo.dao.Users;

import java.util.Date;

public class LoanDto {


    private Date dataLoan;
    private Date dataReturn;
    private Integer idUser;
    private Integer idCopy;

    public LoanDto() {
    }

    public LoanDto(Date dataLoan, Date dataReturn, Integer idUser, Integer idCopy) {
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Integer idCopy) {
        this.idCopy = idCopy;
    }
}
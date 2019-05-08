package com.example.demo.dto;


import java.util.Date;

public class LoanDto {


    private Date dataLoan;
    private Date dataReturn;
    private UsersDto idUser;
    private CopyDto idCopy;

    public LoanDto() {
    }

    public LoanDto(Date dataLoan, Date dataReturn, UsersDto idUser, CopyDto idCopy) {
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

    public UsersDto getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersDto idUser) {
        this.idUser = idUser;
    }

    public CopyDto getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(CopyDto idCopy) {
        this.idCopy = idCopy;
    }
}
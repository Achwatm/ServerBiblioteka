package com.example.demo.dao;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan",schema = "public")

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private Integer idLoan;
    @Column(name = "data_loan")
    private Date dataLoan;
    @Column(name = "date_return")
    private Date dataReturn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private Users idUser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_copy")
    private Copy idCopy;

    public Loan() {
    }

    public Loan(Date dataLoan, Date dataReturn, Users idUser, Copy idCopy) {
        this.dataLoan = dataLoan;
        this.dataReturn = dataReturn;
        this.idUser = idUser;
        this.idCopy = idCopy;
    }

    public Integer getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Integer idLoan) {
        this.idLoan = idLoan;
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
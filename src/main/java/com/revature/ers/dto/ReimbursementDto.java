package com.revature.ers.dto;

import com.revature.ers.models.Status;
import com.revature.ers.models.User;

import java.sql.Date;

public class ReimbursementDto {
    private int reimbursementId;
    private Status status;
    private User author;
    private String firstname;
    private String lastname;
    private User resolver;
    private double reimbursementAmount;
    private String detail;
    private String email;
    private Date date;
    private String username;

    public ReimbursementDto() {
    }

    public ReimbursementDto(int reimbursementId, Status status, User author, String firstname, String lastname, User resolver, double reimbursementAmount, String detail, String email, Date date, String username) {
        this.reimbursementId = reimbursementId;
        this.status = status;
        this.author = author;
        this.firstname = firstname;
        this.lastname = lastname;
        this.resolver = resolver;
        this.reimbursementAmount = reimbursementAmount;
        this.detail = detail;
        this.email = email;
        this.date = date;
        this.username = username;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

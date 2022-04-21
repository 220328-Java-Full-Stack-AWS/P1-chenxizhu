package com.revature.ers.models;


import java.sql.Date;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {
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

    public Reimbursement() {
    }

    public Reimbursement(int reimbursementId, Status status, User author, String firstname, String lastname, User resolver, double reimbursementAmount, String detail, String email, Date date, String username) {
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

    //constructor for createRequest() in ReimbursementDAO
    public Reimbursement(String firstname, String lastname, double reimbursementAmount, String detail, String email, Date date, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
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

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public User getAuthor() {
        return author;
    }

    @Override
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

    @Override
    public User getResolver() {
        return resolver;
    }

    @Override
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

    /**
     * This includes the minimum parameters needed for the {@link AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", status=" + status +
                ", author=" + author +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", resolver=" + resolver +
                ", reimbursementAmount=" + reimbursementAmount +
                ", detail='" + detail + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}

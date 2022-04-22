package com.revature.ers.dto;

import com.revature.ers.models.Role;

public class UserDto {
    private String username;
    private String password;
    private String email;
    private String first;
    private String last;
    private double reimbursementAmount;
    private Integer numberOfReimbursements;
    private Role role;
    private int userId;

    public UserDto() {
    }

    public UserDto(String username, String password, String email, String first, String last, double reimbursementAmount, Integer numberOfReimbursements, Role role, int userId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first = first;
        this.last = last;
        this.reimbursementAmount = reimbursementAmount;
        this.numberOfReimbursements = numberOfReimbursements;
        this.role = role;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public Integer getNumberOfReimbursements() {
        return numberOfReimbursements;
    }

    public void setNumberOfReimbursements(Integer numberOfReimbursements) {
        this.numberOfReimbursements = numberOfReimbursements;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

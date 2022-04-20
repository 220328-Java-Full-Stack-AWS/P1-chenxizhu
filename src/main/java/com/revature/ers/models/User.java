package com.revature.ers.models;

import java.util.HashSet;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {
    private String username;
    private String password;

    private String email;
    private String first;
    private String last;
    private String reimbursementAmount;
    private Integer numberOfReimbursements;
    private Role role;
    private int id;

    private boolean requestStatus;

    public User() {
    }

    public User(String username, String password, String email, String first, String last, String reimbursementAmount, Integer numberOfReimbursements, Role role, int id, boolean requestStatus) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first = first;
        this.last = last;
        this.reimbursementAmount = reimbursementAmount;
        this.numberOfReimbursements = numberOfReimbursements;
        this.role = role;
        this.id = id;
        this.requestStatus = requestStatus;
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

    public String getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(String reimbursementAmount) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * This includes the minimum parameters needed for the {@link AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */
    public User(int id, String username, String password, Role role) {

        //super(id, username, password, role);
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", reimbursementAmount='" + reimbursementAmount + '\'' +
                ", reimbursement='" + numberOfReimbursements + '\'' +
                ", role=" + role +
                ", id=" + id +
                ", requestStatus=" + requestStatus +
                '}';
    }

    //@Override
    public int compareTo(User o) {
        return 0;
    }
}

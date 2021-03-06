package com.revature.ers.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 * <p>
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 */
public class User extends AbstractUser {
    private String username;
    private String password;

    private String email;
    private String first;
    private String last;
    private double reimbursementAmount;
    private Integer numberOfReimbursements;
    private Role role;
    private int userId;

    private boolean requestStatus;

    public User() {
    }

    public User(String username, String password, String email, String first, String last, double reimbursementAmount, Integer numberOfReimbursements, Role role, int userId, boolean requestStatus) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first = first;
        this.last = last;
        this.reimbursementAmount = reimbursementAmount;
        this.numberOfReimbursements = numberOfReimbursements;
        this.role = role;
        this.userId = userId;
        this.requestStatus = requestStatus;
    }

    //constructor for updateUser() in UserDAO
    public User(String username, String first, String last, String email, double reimbursementAmount) {
        this.username = username;
        this.email = email;
        this.first = first;
        this.last = last;
        this.reimbursementAmount = reimbursementAmount;
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
    public User(int userId, String username, String password, Role role) {

        //super(id, username, password, role);
        this.userId = userId;
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
                "\nusername='" + username + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nemail='" + email + '\'' +
                ", \nfirst='" + first + '\'' +
                ", \nlast='" + last + '\'' +
                ", \nreimbursementAmount='" + reimbursementAmount + '\'' +
                ", \nreimbursement='" + numberOfReimbursements + '\'' +
                ", \nrole=" + role +
                ", \nid=" + userId +
                ", \nrequestStatus=" + requestStatus +
                '}';
    }


}

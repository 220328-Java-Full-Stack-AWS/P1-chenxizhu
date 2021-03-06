package com.revature.ers.repositories;

import com.revature.ers.ConnectionManager;
import com.revature.ers.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;



public class UserDAO implements userdaoI {




    //create new user

    public User createUser(User u) {
        String sql = "INSERT INTO user_table (username, password) VALUES(?, ?)";

        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }



    //returns a list of the entire content of User table
    public List<User> getAllUsers() {
        List<User> User = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM user_table";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                User.add(user);
                //System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return User;
        //return null;
    }

    //read
    public User userAuth(String username, String password) {



        User user = new User();
        try {
            String SQL = "select * from user_table where username = ? and password = ?;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            String databaseUsername = "";
            String databasePassword = "";

            while(rs.next()) {
                //User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                return user;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;


    }

    public User getUserByUserName(String username) {
        User user = new User();
        try {
            String SQL = "SELECT * FROM user_table WHERE username = ?;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                //duplicated not necessary statement. causing user not being updated
                //User User = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirst(rs.getString("first_name"));
                user.setLast(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setReimbursementAmount(rs.getDouble("reimbursementamount"));
                user.setUserId(rs.getInt("user_id"));
                System.out.println("print from UserDAO: " + user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }



    public User updateUser(User u) {

        String sql = "UPDATE user_table SET (first_name, last_name, email, reimbursementamount) = (?, ?, ?, ?) where username = ?;";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            /*
            String username = u.getUsername();
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            user.setUsername(rs.getString("username"));

             */
            pstmt.setString(1, u.getFirst());
            pstmt.setString(2, u.getLast());
            pstmt.setString(3, u.getEmail());
            pstmt.setDouble(4, u.getReimbursementAmount());
            pstmt.setString(5, u.getUsername());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void deleteUser(User u) {
        String username = u.getUsername();
        String sql = "DELETE FROM user_table WHERE username = ?";

        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDAO() {
    }

    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */


    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }
    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     */


    public User create(User userToBeRegistered) {


        return userToBeRegistered;
    }


}

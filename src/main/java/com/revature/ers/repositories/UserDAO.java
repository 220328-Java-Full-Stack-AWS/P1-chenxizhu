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
    public void saveUser(User u) {
        String sql = "INSERT INTO user_table (username, password) VALUES(?, ?)";

        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public User userAuth(String username, String password) {
        User usermodel = new User();
        try {
            String SQL = "select * from user_table where username = 'username' and password = 'password1234'";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                usermodel.setUsername(rs.getString("username"));
                usermodel.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usermodel;
    }

    public User getUserByUserName(String username) {
        return null;
    }

    public void updateUser(User u) {

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

package com.revature.ers.repositories;

import com.revature.ers.models.User;

import java.util.List;
import java.util.Optional;


public class UserDAO {
    public void saveUser(User u) {

    }

    public static List<User> getAllUsers() {
        List<User> User = null;
        return User;
    }

    User getUserByUserName(String username) {
        return null;
    }

    void updateUser(User u) {

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

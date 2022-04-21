package com.revature.ers.repositories;

import com.revature.ers.models.User;

import java.util.List;

public interface userdaoI<T extends User> {
    //CRUD create read update delete
    User createUser(T u);

    List<User> getAllUsers();

    User getUserByUserName(String username);

    User updateUser(T u);

    void deleteUser(T u);
}

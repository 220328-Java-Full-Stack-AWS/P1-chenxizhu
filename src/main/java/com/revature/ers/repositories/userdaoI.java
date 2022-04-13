package com.revature.ers.repositories;

import com.revature.ers.models.User;

import java.util.List;

public interface userdaoI<T extends User> {
    //CRUD create read update delete
    void saveUser(T u);

    List<User> getAllUsers();

    User getUserByUserName(String username);

    void updateUser(T u);
}

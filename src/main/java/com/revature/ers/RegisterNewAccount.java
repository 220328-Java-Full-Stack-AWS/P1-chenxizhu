package com.revature.ers;
import com.revature.ers.repositories.UserDAO;
import com.revature.ers.services.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisterNewAccount {
    public RegisterNewAccount() {
    }



    public static void main(String[] args) throws SQLException {
        String username, password, confirmPassword;
        Scanner s = new Scanner(System.in);
        System.out.print("Register Your username:");//username:user
        username = s.nextLine();
        if (username.length() < 8) {
            System.out.println("Please input a username longer than 8 letters.");
        }
        System.out.print("Enter password:");//password:user
        password = s.nextLine();
        System.out.print("Confirm password:");//password:user
        confirmPassword = s.nextLine();
        if(password.equals(confirmPassword) && password.length() > 9 && username.length() > 7)
        {
            UserDAO userDAO = new UserDAO();

            //userDAO.saveUser(User);
            UserService userService = new UserService(new UserDAO());
            userService.register(username, password);
            System.out.println(userDAO.getAllUsers());
            System.out.println("Registration Successful");
            //code to store the data in the database

            //jump to login again
            new LoginOrRegister();
            LoginOrRegister.main(new String[]{"abed"});
        }
        else
        {
            System.out.println("Registration Failed. You might want to use a longer username and password.");
        }
        if (!password.equals(confirmPassword)) {
            System.out.println("Password not matching.");
        }
    }
}

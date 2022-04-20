package com.revature.ers;

import com.revature.ers.models.User;
import com.revature.ers.repositories.UserDAO;
import com.revature.ers.services.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginOrRegister {
    public LoginOrRegister() {
    }
    public static void main(String[] args) throws SQLException {
        //use boolean for login or register?
        String login, register;
        Scanner s = new Scanner(System.in);
        System.out.print("Do you want to login?");//username:user
        login = s.nextLine();
        if(login.equals("y")) {
            //new Login();
            //Login.main(new String[]{"abed"}, "dfd");
            String username, password;

            //UserService userserv = new UserService(new UserDAO());

            System.out.print("Enter username:");//username:user
            username = s.nextLine();
            System.out.print("Enter password:");//password:user
            password = s.nextLine();

            UserService userService = new UserService(new UserDAO());
            userService.login(username, password);
        }
        else {
            new RegisterNewAccount();
            RegisterNewAccount.main(new String[]{});
        }



        //RegisterNewAccount register = new RegisterNewAccount();
        //RegisterNewAccount.main(new String[]{"abed"}, "dfd");



    }
}

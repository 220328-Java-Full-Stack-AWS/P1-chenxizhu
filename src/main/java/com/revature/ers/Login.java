package com.revature.ers;
import com.revature.ers.repositories.UserDAO;
import com.revature.ers.services.UserService;

import java.util.Scanner;

import static org.graalvm.compiler.options.OptionType.User;

public class Login {
    public Login() {
    }

    public static void main(String[] args, String abc) {

        String usernameauth, passwordauth;
        UserService userservice = new UserService(User.equals(username));
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username:");//username:user
        usernameauth = s.nextLine();
        System.out.print("Enter password:");//password:user
        passwordauth = s.nextLine();
        if(usernameauth.equals(userservice.User.login(username)) && passwordauth.equals("user"))
        {
            System.out.println("Authentication Successful");
            //display dashboard function;
            new userOrAdmin();
            userOrAdmin.main(new String[]{}, "");
        }
        else
        {
            System.out.println("Authentication Failed");
            new LoginOrRegister();
            LoginOrRegister.main(new String[]{});
        }
    }
}

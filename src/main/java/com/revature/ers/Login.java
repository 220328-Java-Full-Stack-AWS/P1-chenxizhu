package com.revature.ers;
import com.revature.ers.repositories.ReimbursementDAO;
import com.revature.ers.repositories.UserDAO;
import com.revature.ers.services.UserService;

import java.util.Scanner;
import com.revature.ers.models.User;
//import static org.graalvm.compiler.options.OptionType.User;

public class Login {
    public Login() {
    }

    public static void main(String[] args, String abc) {

        String username, password;
        User user = new User();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username:");//username:user
        username = s.nextLine();
        System.out.print("Enter password:");//password:user
        password = s.nextLine();
        if(
                username.length() > 7
                //username.equals(user.getUsername()) && password.equals(user.getPassword())
        )
        {
            UserService userserv = new UserService(new UserDAO());
            //UserDAO userDAO = new UserDAO();
            userserv.login(username, password);
            System.out.println("Authentication Successful");
            //display dashboard function;
            new userOrAdmin();
            userOrAdmin.main(new String[]{}, "");
        }
        else
        {
            System.out.println("Authentication Failed");
            System.out.println(user.getUsername());
            new LoginOrRegister();
            LoginOrRegister.main(new String[]{});
        }
    }
}

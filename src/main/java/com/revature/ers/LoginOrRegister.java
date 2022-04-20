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

            //finally worked by completing and using getUserByUsername(username)
            UserDAO userdao = new UserDAO();
            try {
                String userTypedPassword = userdao.getUserByUserName(username).getPassword();
                if (userTypedPassword.equals(password)) {
                    System.out.println(userdao.getUserByUserName(username).getPassword());
                    System.out.println("Authentication Successful");
                    //display dashboard function;
                    new userOrAdmin();
                    userOrAdmin.main(new String[]{}, "");
                }
                /*
                else {
                    System.out.println("Authentication Failed");

                    new LoginOrRegister();
                    LoginOrRegister.main(new String[]{});
                }

                 */
            } catch (NullPointerException N) {

                // catch null pointer exception when typed username is not in the database username column
                System.out.println("Authentication Failed");

                new LoginOrRegister();
                LoginOrRegister.main(new String[]{});
            }
        }
        else {
            new RegisterNewAccount();
            RegisterNewAccount.main(new String[]{});
        }



        //RegisterNewAccount register = new RegisterNewAccount();
        //RegisterNewAccount.main(new String[]{"abed"}, "dfd");



    }
}

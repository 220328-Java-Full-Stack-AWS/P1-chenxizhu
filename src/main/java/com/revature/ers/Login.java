package com.revature.ers;
import java.util.Scanner;

public class Login {
    public Login() {
    }

    public static void main(String[] args, String abc) {

        String username, password;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username:");//username:user
        username = s.nextLine();
        System.out.print("Enter password:");//password:user
        password = s.nextLine();
        if(username.equals("user") && password.equals("user"))
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
            LoginOrRegister.main(new String[]{"abed"}, "dfd");
        }
    }
}

package com.revature.ers;

import java.util.Scanner;

public class LoginOrRegister {
    public LoginOrRegister() {
    }
    public static void main(String[] args) {
        //use boolean for login or register?
        String login, register;
        Scanner s = new Scanner(System.in);
        System.out.print("Do you want to login?");//username:user
        login = s.nextLine();
        if(login.equals("y")) {
            new Login();
            Login.main(new String[]{"abed"}, "dfd");
        }
        else {
            new RegisterNewAccount();
            RegisterNewAccount.main(new String[]{});
        }



        //RegisterNewAccount register = new RegisterNewAccount();
        //RegisterNewAccount.main(new String[]{"abed"}, "dfd");



    }
}

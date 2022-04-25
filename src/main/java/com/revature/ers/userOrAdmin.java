package com.revature.ers;

import java.util.Scanner;

public class userOrAdmin {
    public userOrAdmin() {
    }

    public static void main(String[] args, String dfd) {
        //use boolean for login or register?
        String user, admin;
        Scanner s = new Scanner(System.in);
        System.out.print("admin password:");//username:user
        admin = s.nextLine();
        if (admin.equals("admin")) {
            new AdminOptions();
            AdminOptions.printAllRequests(new String[]{});
            AdminOptions.main(new String[]{});
            AdminOptions.printMenu(new String[]{""});
            System.out.println("You now have admin access.");
        } else {
            System.out.println("Welcome peasant.");
            //enter user interface
            new UserOptions();
            UserOptions.main(new String[]{""});
            UserOptions.printMenu(new String[]{""});
        }

    }
}

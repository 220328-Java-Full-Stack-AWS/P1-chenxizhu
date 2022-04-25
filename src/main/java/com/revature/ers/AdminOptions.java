package com.revature.ers;

import com.revature.ers.repositories.ReimbursementDAO;

import java.util.Scanner;

import static java.lang.System.exit;

public class AdminOptions {
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void printAllRequests(String[] options) {
        ReimbursementDAO reimbursementd = new ReimbursementDAO();
        System.out.println(reimbursementd.showMyRequests());
    }

    public static void main(String[] args) {
        String[] options = {"1- Option 1",
                "2- Option 2",
                "3- Option 3",
                "4- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 4) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {

                    case 1:
                        option1();
                        break;
                    case 2:
                        option2();
                        break;
                    case 3:
                        option3();
                        break;
                    case 4:
                        exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    // Options
    private static void option1() {
        System.out.println("Thanks for choosing option 1");
    }

    private static void option2() {
        System.out.println("Thanks for choosing option 2");
    }

    private static void option3() {
        System.out.println("Thanks for choosing option 3");
    }
}
package com.revature.ers;

import java.util.Scanner;
import static java.lang.System.exit;

public class UserOptions {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void main(String[] args) {
        String[] options = {
                "1- Send request for reimbursement",
                "2- Cancel my request for reimbursement",
                "3- View my pending and completed past requests",
                "4- Edit my pending requests for reimbursement",
                "5- Exit"
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=5){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: option1();
                    break;
                    case 2: option2();
                    break;
                    case 3: option3();
                    break;
                    case 4: option4();
                    break;
                    case 5: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }
    // Options
    private static void option1() {
        System.out.println("1- Send request for reimbursement");
        //send request for reimbursement
    }
    private static void option2() {
        System.out.println("2- Cancel my request for reimbursement");
        //cancel my request for reimbursement
    }
    private static void option3() {
        System.out.println("3- View my pending and completed past requests");
        //view my pending and completed past requests
    }
    private static void option4() {
        System.out.println("4- Edit my pending requests for reimbursement");
        //edit my pending requests for reimbursement
    }


}
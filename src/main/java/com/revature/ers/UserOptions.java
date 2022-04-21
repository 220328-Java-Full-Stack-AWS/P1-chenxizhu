package com.revature.ers;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;
import com.revature.ers.repositories.ReimbursementDAO;
import com.revature.ers.repositories.UserDAO;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;
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

        String username, firstname, lastname, email, detail, date;
        Double reimbursementAmount = 0.00;

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your user name:");//firstname:Reimbursement Model
        username = s.nextLine();
        System.out.print("Enter your first name:");//firstname:Reimbursement Model
        firstname = s.nextLine();
        System.out.print("Enter your last name:");//lastname:Reimbursement Model
        lastname = s.nextLine();
        System.out.print("Enter your email:");//lastname:Reimbursement Model
        email = s.nextLine();
        System.out.print("Enter details and nature of your request:");//detail:Reimbursement Model
        detail = s.nextLine();
        System.out.print("Enter today's date(yyyy-mm-dd):");//date:Reimbursement Model
        date = s.nextLine();
        System.out.print("Enter reimbursement amount:");//lastname:Reimbursement Model
        reimbursementAmount = s.nextDouble();

        Reimbursement r = new Reimbursement(firstname, lastname, reimbursementAmount, detail, email, Date.valueOf(date), username);
        ReimbursementService rd = new ReimbursementService(new ReimbursementDAO());
        rd.create(r);
        System.out.println("request summary");
        System.out.println(r);
        System.out.println("Request Submitted");


        UserService userService = new UserService(new UserDAO());
        com.revature.ers.models.User u = new User(username, firstname, lastname, email, reimbursementAmount);
        System.out.println("Updating user profile");
        userService.update(u);
        System.out.println("User profile updated");
        System.out.println(u);

        //send request for reimbursement
    }
    private static void option2() {
        System.out.println("2- Request not yet Canceled.");
        //cancel my request for reimbursement
    }
    private static void option3() {
        String username;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your user name:");//firstname:Reimbursement Model
        username = s.nextLine();
        UserDAO userdao = new UserDAO();
        if (userdao.getUserByUserName(username).getUsername().equals(username)) {
            ReimbursementService rd = new ReimbursementService(new ReimbursementDAO());
            Reimbursement r = new Reimbursement();
            rd.readMyRequest(r);
            System.out.println("printing out r");
            System.out.println(r);

            System.out.println("3- View my pending and completed past requests");
            //view my pending and completed past requests
        }
    }
    private static void option4() {
        System.out.println("4- Edit my pending requests for reimbursement");
        //edit my pending requests for reimbursement
    }


}
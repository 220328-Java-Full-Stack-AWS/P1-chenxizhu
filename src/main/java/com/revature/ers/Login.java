package com.revature.ers;
import com.revature.ers.repositories.ReimbursementDAO;
import com.revature.ers.repositories.UserDAO;
import com.revature.ers.services.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.ers.models.User;
//import static org.graalvm.compiler.options.OptionType.User;

public class Login {

    public UserDAO ud;

    public Login() {
    }

    public static void main(String[] args, String abc) throws SQLException {
        String username, password;
        User user = new User();
        //UserService userserv = new UserService(new UserDAO());
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username:");//username:user
        username = s.nextLine();
        System.out.print("Enter password:");//password:user
        password = s.nextLine();


        /*
        //create sql query
        User usermodel = new User();
        String databaseUsername = "", databasePassword =  "";
        String SQL = "select * from user_table where username = ? and password = ?;";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, databaseUsername);
        pstmt.setString(2, databasePassword);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            usermodel.setUsername(rs.getString("username"));
            usermodel.setPassword(rs.getString("password"));

        */
       if (
               ud.userAuth(username,password)
               //username.length() > 7
                //username.equals(databaseUsername) && password.equals(databasePassword)
                //UserDAO.userAuth();
                //username.equals(user.getUsername()) && password.equals(user.getPassword())
        )
        {

            UserDAO userDAO = new UserDAO();
            UserService userService = new UserService(new UserDAO());
            userService.login(username, password);
            //System.out.println(userDAO.getAllUsers());
            System.out.println(userDAO.getUserByUserName(username));
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

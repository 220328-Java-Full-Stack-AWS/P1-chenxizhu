package com.revature.ers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ErsDriver {


    public static void main(String[] args) throws SQLException {
        try {
            Connection conn = ConnectionManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("Employment Reimbursement System. Please register or Login.");
        //new LoginOrRegister();
        LoginOrRegister.main(new String[]{});

    }



}

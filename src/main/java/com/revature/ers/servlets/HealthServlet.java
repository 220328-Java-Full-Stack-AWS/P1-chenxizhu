package com.revature.ers.servlets;

import com.revature.ers.ErsDriver;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("health check passed!");
        resp.setStatus(200);
        resp.getWriter().print("Pong!");

        resp.getWriter().print(new ErsDriver());

        PrintWriter pw = resp.getWriter();
        pw.print("stuff");
        resp.getWriter().print("stuff");
    }
}

package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.GlobalObjectStore;
import com.revature.ers.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) GlobalObjectStore.getObject(req.getHeader("username"));
        resp.setStatus(200);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(userDto));
    }
}

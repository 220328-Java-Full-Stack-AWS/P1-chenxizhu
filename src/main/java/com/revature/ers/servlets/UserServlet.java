package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.GlobalObjectStore;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserDAO uDao;

    private ObjectMapper mapper;

    public void init() throws ServletException {
        this.uDao = new UserDAO();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userdao = new UserDAO();
        User user = userdao.getUserByUserName(req.getHeader("username"));
        //UserDto userDto = (UserDto) GlobalObjectStore.getObject(req.getHeader("username"));
        //GlobalObjectStore.addObject("jason1234", new User("username", "first", "last", "email", 99.99));
        //User user = (User) GlobalObjectStore.getObject(req.getHeader("username"));
        resp.setStatus(200);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(user));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Printing from UserServlet doPost " + req.getHeader("mode"));
        switch (req.getHeader("mode")) {
            case "register":
                User newUser = new ObjectMapper().readValue(req.getInputStream(), User.class);
                //User newUser = mapper.readValue(req.getReader().toString(), User.class);
                //System.out.println(newUser);
                uDao.createUser(newUser);
                //GlobalObjectStore.addObject(newUser.getUsername(), newUser);
                resp.setStatus(201);
                resp.getWriter().print(new ObjectMapper().writeValueAsString(newUser));
                resp.setHeader("access-control-expose-headers", "authToken");
                resp.setHeader("authToken", newUser.getUsername());
                break;

            case "login":
                System.out.println("Printing from UserServelet doPost login " + req.getHeader("username") + "\n" + req.getHeader("password"));
                //System.out.println(uDao.getUserByUserName(req.getHeader("username")));
                User checkUser = uDao.getUserByUserName(req.getHeader("username"));
                System.out.println("Printing from UserServlet checkUser: " + checkUser);
                User authUser = new ObjectMapper().readValue(req.getInputStream(), User.class);
                //User checkUser = (User) GlobalObjectStore.getObject(authUser.getUsername());
                if (checkUser != null && checkUser.getPassword().equals(authUser.getPassword())) {
                    System.out.println("Printing from UserServlet pass login password check: " + checkUser.getPassword());
                    resp.setStatus(200);
                    resp.getWriter().print(new ObjectMapper().writeValueAsString(checkUser));
                    resp.setHeader("access-control-expose-headers", "authToken");
                    resp.setHeader("authToken", checkUser.getUsername());
                    resp.getWriter().print("User Authenticated.");
                } else {
                    resp.setStatus(401);
                }
            /*
                User authUser = new ObjectMapper().readValue(req.getInputStream(), User.class);
                User checkUser = (User) GlobalObjectStore.getObject(authUser.getUsername());
                if (checkUser != null && checkUser.getPassword().equals(authUser.getPassword())) {
                    resp.setStatus(200);
                    resp.getWriter().print(new ObjectMapper().writeValueAsString(checkUser));
                    resp.setHeader("access-control-expose-headers", "authToken");
                    resp.setHeader("authToken", checkUser.getUsername());
                    resp.getWriter().print("User Authenticated.");
                } else {
                    resp.setStatus(401);
                }

             */
                break;
            default:
                resp.setStatus(400);
                break;
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User updateUser = new ObjectMapper().readValue(req.getInputStream(), User.class);
        GlobalObjectStore.removeObject(updateUser.getUsername());
        GlobalObjectStore.addObject(updateUser.getUsername(), updateUser);
        resp.setStatus(200);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(updateUser));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GlobalObjectStore.removeObject((req.getHeader("username")));
        resp.setStatus(200);
    }
}

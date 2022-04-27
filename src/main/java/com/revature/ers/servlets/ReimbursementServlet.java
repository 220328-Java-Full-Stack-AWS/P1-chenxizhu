package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repositories.ReimbursementDAO;
import com.revature.ers.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementServlet extends HttpServlet {

    private ReimbursementService rServ;
    private ObjectMapper mapper;

    public void init() throws ServletException {
        this.rServ = new ReimbursementService(new ReimbursementDAO());
        this.mapper = new ObjectMapper();
    }

    //view requests
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReimbursementDAO reimbursementdao = new ReimbursementDAO();
        Reimbursement reimbursement = reimbursementdao.getRequestsById(Integer.parseInt(req.getHeader("reimburse_id")));
        resp.setStatus(200);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(reimbursement));
    }

    //create new request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Printing from Reimbursement Servlet doPost " + req.getHeader("firstname"));
        //new ObjectMapper().readValue(req.getInputStream(), User.class);
        //Reimbursement newReimbursement = mapper.readValue(req.getReader().toString(), Reimbursement.class);

        Reimbursement newReimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
        //System.out.println(newUser);
        System.out.println("Print from ReimbursementServlet: " + newReimbursement);
        rServ.create(newReimbursement);
        //GlobalObjectStore.addObject(newUser.getUsername(), newUser);
        resp.setStatus(201);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(newReimbursement));
        resp.setHeader("access-control-expose-headers", "authToken");
        resp.setHeader("authToken", newReimbursement.getUsername());
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}

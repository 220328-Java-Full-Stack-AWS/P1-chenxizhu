package com.revature.ers.repositories;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;

import java.util.List;

public interface ReimbursementDInterface<R extends ReimbursementDInterface> {

    //CRUD create read update delete
    //create
    void createRequest(R r);
    //read
    List<Reimbursement> showMyRequests();
    Reimbursement getRequestsByAuthor(User author);

    //update,edit requests
    void updateMyRequests(R r);

    //delete, cancel my requests
    void cancelMyRequests(R r);
}

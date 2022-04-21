package com.revature.ers.repositories;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;

import java.util.List;

public interface ReimbursementDInterface<R extends Reimbursement> {

    //CRUD create read update delete
    //create
    Reimbursement createRequest(R r);
    //read
    List<Reimbursement> showMyRequests();
    Reimbursement getRequestsByAuthor(User author);

    //update,edit requests
    Reimbursement updateMyRequests(R r);

    //delete, cancel my requests
    void cancelMyRequests(R r);
}

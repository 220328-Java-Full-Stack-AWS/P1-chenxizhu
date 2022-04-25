package com.revature.ers.services;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.repositories.ReimbursementDAO;

/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 * <p>
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 * <p>
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */
public class ReimbursementService {
    public ReimbursementDAO rd;

    public ReimbursementService(ReimbursementDAO rd) {
        this.rd = rd;
    }

    //create
    public Reimbursement create(Reimbursement r) {
        return rd.createRequest(r);
    }

    // read by username
    public Reimbursement readMyRequest(String username) {
        return rd.getRequestsByUsername(username);
    }

    //read by id
    public Reimbursement readRequestById(int reimbursementId) {
        return rd.getRequestsById(reimbursementId);
    }

    //edit
    public Reimbursement update(Reimbursement r) {
        return rd.updateMyRequests(r);
    }

    public void delete(Reimbursement r) {
        rd.cancelMyRequests(r);
    }
}

/**
 * <ul>
 *     <li>Should ensure that the user is logged in as a Finance Manager</li>
 *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
 *     <li>Should ensure that the reimbursement request exists</li>
 *     <li>Must throw exception if the reimbursement request is not found</li>
 *     <li>Should persist the updated reimbursement status with resolver information</li>
 *     <li>Must throw exception if persistence is unsuccessful</li>
 * </ul>
 * <p>
 * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
 * The Resolver should be null. Additional fields may be null.
 * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
 */


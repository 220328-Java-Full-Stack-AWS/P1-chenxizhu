package com.revature.ers.models;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {
    private int reimbursementId;
    private Status status;
    private User author;
    private User resolver;
    private double reimbursementAmount;

    public Reimbursement(int reimbursementId, Status status, User author, User resolver, double reimbursementAmount) {
        this.reimbursementId = reimbursementId;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.reimbursementAmount = reimbursementAmount;
    }

    public Reimbursement() {
    }

    /**
     * This includes the minimum parameters needed for the {@link AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */

}

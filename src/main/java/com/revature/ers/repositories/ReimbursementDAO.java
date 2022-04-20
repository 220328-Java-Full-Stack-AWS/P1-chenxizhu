package com.revature.ers.repositories;

import com.revature.ers.ConnectionManager;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.User;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

//import static sun.text.bidi.BidiBase.R;

public class ReimbursementDAO implements ReimbursementDInterface {
    public ReimbursementDAO() {
    }

    //CRUD create read update delete
    //create
    /*
    public void createRequest(Reimbursement r){

    }
    */
    //create

    public void createRequest(Reimbursement r) {
        String sql = "insert into reimburse_table (username, first_name, last_name, email,reimbursementamount, detail, submit_date) values (?, ?, ?, ?, ?, ?, ?);" +
                "update user_table set (first_name, last_name, email, reimbursementamount) = (?, ?, ?, ?) where username = ?;";


        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, r.getUsername());
            pstmt.setString(2, r.getFirstname());
            pstmt.setString(3, r.getLastname());
            pstmt.setString(4, r.getEmail());
            pstmt.setDouble(5, r.getReimbursementAmount());
            pstmt.setString(6, r.getDetail());
            pstmt.setDate(7, r.getDate());



            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //read
    public List<Reimbursement> showMyRequests() {
        List<Reimbursement> Reimbursement = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM reimburse_table;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Reimbursement reimbursement  = new Reimbursement();
                reimbursement.setFirstname(rs.getString("first_name"));
                reimbursement.setLastname(rs.getString("last_name"));
                reimbursement.setEmail(rs.getString("email"));
                reimbursement.setReimbursementAmount(rs.getDouble("reimbursementamount"));
                reimbursement.setDetail(rs.getString("detail"));
                reimbursement.setDate(rs.getDate("submit_date"));
                Reimbursement.add(reimbursement);
                //System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Reimbursement;
    }


    //yea not using it
    @Override
    public Reimbursement getRequestsByAuthor(User author) {
        return null;
    }


    //read
    public Reimbursement getRequestsByUsername(User username) {
        List<Reimbursement> Reimbursement1 = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM reimburse_table WHERE username = ?;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Reimbursement reimbursement  = new Reimbursement();
                reimbursement.setFirstname(rs.getString("first_name"));
                reimbursement.setLastname(rs.getString("last_name"));
                reimbursement.setEmail(rs.getString("email"));
                reimbursement.setReimbursementAmount(rs.getDouble("reimbursementamount"));
                reimbursement.setDetail(rs.getString("detail"));
                reimbursement.setDate(rs.getDate("submit_date"));
                Reimbursement1.add(reimbursement);
                //System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Reimbursement) Reimbursement1;
    };

    //update,edit requests
    public void updateMyRequests(Reimbursement r){
        String sql = "UPDATE reimburse_table SET first_name, last_name, email,reimbursementamount, detail, submit_date  WHERE reimburse_id = ?";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, r.getFirstname());
            pstmt.setString(2, r.getLastname());
            pstmt.setString(2, r.getEmail());
            pstmt.setDouble(2, r.getReimbursementAmount());
            pstmt.setString(2, r.getDetail());
            pstmt.setDate(3, r.getDate());
            //pstmt.setBoolean(4, r.isCompleted());
            //pstmt.setInt(5, r.getItemId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    };

    //delete, cancel my requests
    public void cancelMyRequests(Reimbursement r){
        String sql = "DELETE FROM reimburser_table WHERE reimburse_id = ?";

        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, r.getReimbursementId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    /*
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }
*/
    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
}

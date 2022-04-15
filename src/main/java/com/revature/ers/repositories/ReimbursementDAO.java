package com.revature.ers.repositories;

import com.revature.ers.ConnectionManager;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO extends ReimbursementDInterface {
    public ReimbursementDAO() {
    }

    //CRUD create read update delete
    //create
    /*
    public void createRequest(Reimbursement r){

    }
    */
    //create
    @Override
    public void createRequest(ReimbursementDInterface r) {
        String sql = "INSERT INTO user_table (username, password) VALUES(?, ?)";

        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(1, u.getUsername());
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> showMyRequests() {
        List<User> User = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM user_table";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                User.add(user);
                //System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return User;
    }

    @Override
    public Reimbursement getRequestsByAuthor(User author) {
        return null;
    }

    @Override
    public void updateMyRequests(ReimbursementDInterface r) {

    }

    @Override
    public void cancelMyRequests(ReimbursementDInterface r) {

    }
};

    //read
    public List<Reimbursement> showMyRequests(Reimbursement reimbursement) {
        List<Reimbursement> reimbursement = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM reimbursement_table WHERE username = ?";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setUsername(rs.getString("username"));
            reimbursement.setPassword(rs.getString("password"));
            Reimbursement.add(reimbursement);
            //System.out.println(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return Reimbursement;
        //return null;
        };

    Reimbursement getRequestsByAuthor(User author) {

    };

    //update,edit requests
    public void updateMyRequests(Reimbursement r){

    };

    //delete, cancel my requests
    public void cancelMyRequests(Reimbursement r){

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

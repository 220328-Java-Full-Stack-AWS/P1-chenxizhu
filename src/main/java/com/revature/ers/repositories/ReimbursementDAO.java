package com.revature.ers.repositories;

import com.revature.ers.ConnectionManager;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Reimbursement createRequest(Reimbursement r) {
        String sql = "insert into reimburse_table (username, first_name, last_name, email,reimbursementamount, detail, submit_date) values (?, ?, ?, ?, ?, ?, ?);";


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
        return r;
    }


    //read at the moment it's show all request
    public List<Reimbursement> showMyRequests() {
        List<Reimbursement> Reimbursement = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM reimburse_table;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Reimbursement reimbursement = new Reimbursement();
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
    public Reimbursement getRequestsByUsername(String username) {
        Reimbursement reimbursement = new Reimbursement();
        try {
            String SQL = "SELECT * FROM reimburse_table WHERE username = ?;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("Here're the requests submitted under your user name.");
            while (rs.next()) {
                //Reimbursement reimbursement  = new Reimbursement();
                reimbursement.setFirstname(rs.getString("first_name"));
                reimbursement.setLastname(rs.getString("last_name"));
                reimbursement.setEmail(rs.getString("email"));
                reimbursement.setReimbursementAmount(rs.getDouble("reimbursementamount"));
                reimbursement.setDetail(rs.getString("detail"));
                reimbursement.setDate(rs.getDate("submit_date"));
                reimbursement.setReimbursementId(rs.getInt("reimburse_id"));

                System.out.println("Print from ReimbursementDAO: " + reimbursement);
                //System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }

    //read
    public Reimbursement getRequestsById(int reimbursementId) {
        Reimbursement reimbursement = new Reimbursement();
        try {
            String SQL = "SELECT * FROM reimburse_table WHERE reimburse_id = ?;";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, reimbursementId);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("Here's the request based on the ID you enter'.");
            while (rs.next()) {
                //Reimbursement reimbursement  = new Reimbursement();
                reimbursement.setFirstname(rs.getString("first_name"));
                reimbursement.setLastname(rs.getString("last_name"));
                reimbursement.setEmail(rs.getString("email"));
                reimbursement.setReimbursementAmount(rs.getDouble("reimbursementamount"));
                reimbursement.setDetail(rs.getString("detail"));
                reimbursement.setDate(rs.getDate("submit_date"));
                reimbursement.setReimbursementId(rs.getInt("reimburse_id"));

                System.out.println("Print from ReimbursementDAO get request by ID: " + reimbursement);
                //System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }

    //update,edit requests
    public Reimbursement updateMyRequests(Reimbursement r) {
        String sql = "UPDATE reimburse_table SET (first_name, last_name, email, reimbursementamount, detail) = (?, ?, ?, ?, ?) WHERE reimburse_id = ?;";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, r.getFirstname());
            pstmt.setString(2, r.getLastname());
            pstmt.setString(3, r.getEmail());
            pstmt.setDouble(4, r.getReimbursementAmount());
            pstmt.setString(5, r.getDetail());
            pstmt.setInt(6, r.getReimbursementId());
            //pstmt.setDate(3, r.getDate());
            //pstmt.setBoolean(4, r.isCompleted());
            //pstmt.setInt(5, r.getItemId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    //delete, cancel my requests
    public void cancelMyRequests(Reimbursement r) {
        String sql = "DELETE FROM reimburse_table WHERE reimburse_id = ?";

        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, r.getReimbursementId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendlord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author f1nn
 */
public class lendlordDAO {

    public boolean isExistUser(String username, int Role) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM [Lendlord] WHERE ";
        String landlord = "[lendUsername] = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = sql + landlord;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("ERROR " + ex.getMessage());
            }
        }
        return true;

    }

    public int registerLandlord(lendlordDTO landlord) {
        if (!isExistUser(landlord.getLendUsername(), 2)) {
            System.err.println("[!]ERROR: Username is existed! Try another username");
        }
        String sql = "INSERT INTO Lendlord ([lendUsername], lendPassword, lendEmail, lendPhoneNumber) VALUES"
                + "(?,?,?,?)";
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, landlord.getLendUsername());
            ps.setString(2, landlord.getLendPassword());
            ps.setString(3, landlord.getLendEmail());
            ps.setString(4, landlord.getLendPhoneNumber());
            result = ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            System.out.println("[!]ERROR:" + ex.getMessage());
        }
        return result;

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

        public lendlordDTO loginLend(String user, String pass) {

        String query = "select *	\n"
                + "from [Lendlord]\n"
                + "where lendUsername = ? and lendPassword = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               lendlordDTO lend = new lendlordDTO();

                lend.setLendID(rs.getInt("lendID"));
                lend.setLendUsername(rs.getString("lendUsername"));
                lend.setLendPassword(rs.getString("lendPassword"));
                lend.setLendFullname(rs.getString("lendFullname"));
                lend.setLendPhoneNumber(rs.getString("lendPhoneNumber"));
                lend.setLendEmail(rs.getString("lendEmail"));


                return lend;
            }
        } catch (SQLException ex) {
            System.out.println("Login failed: " + ex.getMessage());
        }
        return null;
    }
}

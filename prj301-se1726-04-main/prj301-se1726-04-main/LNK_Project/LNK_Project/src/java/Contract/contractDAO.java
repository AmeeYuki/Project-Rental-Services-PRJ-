/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DBUtils;

/**
 *
 * @author f1nn
 */
public class contractDAO {
    Connection con;
    public int cancelContractByUser(int contractID) {
        // TODO: implement method to delete a specific contract by ID
        
        String sql = "UPDATE  [dbo].[Contract] SET [contractStatus] = 'CANCELED' WHERE [contractID]  = ? ";
        try {
            con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, contractID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return rowsAffected;// successfull cancellation of contract
            } else {
                System.out.println("No record found for given id");
                return rowsAffected;// no records affected or no such user exists with that email address
            }
        } catch (SQLException sqle) {
        } finally {
            closeConnection(con);
        }
        return 0;
    }

    private void closeConnection(Connection connection) {
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (Exception ignore) {
        }
    }
    public static List<contractDTO> list() throws ClassNotFoundException {
        List<contractDTO> list = new ArrayList<>();
        String sql = "SELECT [contractID],[infoTitle],[BookingDate],[Checkin],[contractStatus] FROM [dbo].[Contract] C join [dbo].[Information] I ON C.[infoID] = I.[infoID]";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new contractDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<contractDTO> getContractByID(int ID) throws ClassNotFoundException {
        List<contractDTO> list = new ArrayList<>();
        String sql = "SELECT [contractID],[BookingDate],[Checkin],[Checkout],[contractStatus] FROM [dbo].[Contract] WHERE [contractID] = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new contractDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void delete(int ID) throws ClassNotFoundException {
        String sql = "UPDATE [dbo].[Contract] SET [contractStatus] = 'Canceled' WHERE [contractID] = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void approve(int ID) throws ClassNotFoundException {
        String sql = "UPDATE [dbo].[Contract] SET [contractStatus] = 'Approved' WHERE [contractID] = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean deleteContract(String contractStatus) {
        String sql = "DELETE FROM [dbo].[Contract] WHERE [contractStatus] = '?'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contractStatus);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Delete Contract error!" + e.getMessage());
        }
        return false;
    }

    }


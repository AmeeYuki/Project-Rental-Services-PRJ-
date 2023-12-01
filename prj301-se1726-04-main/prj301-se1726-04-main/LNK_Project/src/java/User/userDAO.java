/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.Random;
import Contract.contractDTO;
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
public class userDAO {

    public boolean isExistUser(String username, int Role) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM [User] WHERE ";
        String user = "userUsername = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = sql + user;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                //It existed
                count = rs.getInt(1);
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("[!]ERROR: " + ex.getMessage());
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

    public int registerUser(userDTO user) {
        if (!isExistUser(user.getUserUsername(), 1)) {
            System.out.println("[!]ERROR: Username is existed! Try another username");
        }
        String sql = "INSERT INTO [User] (userUsername, userPassword, userEmail, userRole) "
                + " Values(?,?,?,?)";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserUsername());
            ps.setString(2, user.getUserPassword());
            ps.setString(3, user.getUserEmail());
            ps.setInt(4, user.getUserRole());
            result = ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            System.err.println("[!] ERROR: " + ex.getMessage());
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

    public userDTO loginUser(String user, String pass) {

        String query = "SELECT * FROM [User] WHERE userUsername = ? AND userPassword = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userDTO userDTO = new userDTO();

                userDTO.setUserID(rs.getInt("userID"));
                userDTO.setUserUsername(rs.getString("userUsername"));
                userDTO.setUserPassword(rs.getString("userPassword"));
                userDTO.setUserFullname(rs.getString("userFullname"));
                userDTO.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userDTO.setUserEmail(rs.getString("userEmail"));
                userDTO.setUserRole(rs.getInt("userRole"));

                return userDTO;
            }
        } catch (SQLException ex) {
            System.out.println("Login failed: " + ex.getMessage());
        }
        return null;
    }

    public List<contractDTO> getUpcomingContractDTO(String userID) {
        List<contractDTO> bookingList = new ArrayList<>();
        String sql = " SELECT c.[contractID], i.[infoID],  i.[infoTitle],  c.[userID], c.[BookingDate], c.[Checkin], c.[Checkout], c.[contractStatus]   FROM [dbo].[Contract] c  INNER JOIN [dbo].[Information] i ON c.[infoID] = i.[infoID] WHERE c.[userID] = ? AND c.[Checkout] > GETDATE()";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bookingList.add(new contractDTO(rs.getInt("contractID"), rs.getInt("infoID"),
                        rs.getString("bookingDate"), rs.getString("Checkin"), rs.getString("Checkout"),
                        rs.getString("contractStatus"), rs.getString("infoTitle")));
            }
            return bookingList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<contractDTO> searchUpcomming(String name) {
        List<contractDTO> searchUpList = new ArrayList<>();
        String sql = " SELECT c.[contractID], i.[infoID],  i.[infoTitle],  c.[userID], c.[BookingDate], c.[Checkin], c.[Checkout], c.[contractStatus]   FROM [dbo].[Contract] c  INNER JOIN [dbo].[Information] i ON c.[infoID] = i.[infoID] WHERE c.[userID] = ? AND c.[Checkout] > GETDATE()";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                searchUpList.add(new contractDTO(rs.getInt("contractID"), rs.getInt("infoID"),
                        rs.getString("bookingDate"), rs.getString("Checkin"), rs.getString("Checkout"),
                        rs.getString("contractStatus"), rs.getString("infoTitle")));
            }
            return searchUpList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public List<contractDTO> getHistoryContractDTO(String userID) {
        List<contractDTO> historyList = new ArrayList<>();
        String sql = "SELECT [contractID],[infoID],[lendID],[userID],[BookingDate],[Checkin],[Checkout],[contractStatus] FROM [dbo].[Contract] WHERE [userID] = ? and [Checkout] < GETDATE()";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                historyList.add(new contractDTO(rs.getInt("contractID"), rs.getInt("infoID"), rs.getInt("lendID"), rs.getInt("userID"), rs.getString("BookingDate"),
                        rs.getString("CheckIn"), rs.getString("Checkout"), rs.getString("contractStatus")));
            }
            return historyList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    

    public int registerUserbyGoogle(userDTO user) {
        if (!isExistUser(user.getId(), 1)) {
            return 0;
        } else {
            String sql = "INSERT INTO [User] (userUsername, userPassword, userEmail, userRole) "
                    + " Values(?,?,?,?)";

            //due to user login via Google so they dont need to crate a password and we take an random nuber 
            Random rand = new Random();
            int min = 10000000;
            int max = 99999999;
            int randomNumber = rand.nextInt((max - min) + 1) + min;
            String password = String.valueOf(randomNumber);
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            int result = 0;
            try {
                con = DBUtils.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getId());
                ps.setString(2, password);
                ps.setString(3, user.getEmail());
                ps.setInt(4, 1);
                result = ps.executeUpdate();
                return result;
            } catch (SQLException ex) {
                System.err.println("[!] ERROR: " + ex.getMessage());
            }
            return result;
        }

    }
    
    
    public userDTO loginByGoogle(String id){
               String query = "SELECT * FROM [User] WHERE userUsername = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userDTO userDTO = new userDTO();

                userDTO.setUserID(rs.getInt("userID"));
                userDTO.setUserUsername(rs.getString("userUsername"));
                userDTO.setUserPassword(rs.getString("userPassword"));
                userDTO.setUserFullname(rs.getString("userFullname"));
                userDTO.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userDTO.setUserEmail(rs.getString("userEmail"));
                userDTO.setUserRole(rs.getInt("userRole"));

                return userDTO;
            }
        } catch (SQLException ex) {
            System.out.println("Login failed: " + ex.getMessage());
        }
        return null;
    }
    
    
    public userDTO getUserInfo(String userID){
        String sql = "select  [userUsername], [userPassword], [userFullname], [userPhoneNumber] ,[userEmail] from [User] where [userUsername] = ?";
        try{
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new userDTO(rs.getString("userUsername"), 
                                    rs.getString("userPassword"),
                                    rs.getString("userEmail"),
                                    rs.getString("userPhoneNumber"));
                                    
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;    
    }

    public int editUserInfo(String userID, String name, String phone, String email, String password) {
        
        String sql = "UPDATE [dbo].[User] SET [userPassword]= ?, [userFullname] = ? , [userPhoneNumber] = ?, [userEmail] = ?  WHERE [userUsername] = ?" ;
        int result = 0;
        try{    
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, userID);
            result = ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return result;
        
    }
    
    public List<contractDTO> searchByNameUp(String userID, String keyword) {
        List<contractDTO> list = new ArrayList<>();
        String sql = "SELECT [contractID] , [infoTitle], [BookingDate], [Checkin], [contractStatus] FROM \n" +
                        "[dbo].[Contract] FULL JOIN [dbo].[Information] ON [Contract].[infoID] = [Information].[infoID] WHERE [Information].infoTitle LIKE CONCAT('%', ? , '%') AND userID like ? ";
        try{
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1 , keyword);
            ps.setString(2, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new contractDTO(rs.getInt("contractID"),
                        rs.getString("bookingDate"), rs.getString("Checkin"), rs.getString("contractStatus"), rs.getString("infoTitle")));
            }
            
            //int contractID, String bookingDate, String checkInDate, String contractStatus, String infoTitle
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

}

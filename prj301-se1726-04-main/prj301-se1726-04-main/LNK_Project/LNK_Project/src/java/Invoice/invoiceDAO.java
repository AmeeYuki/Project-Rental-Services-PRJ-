/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author f1nn
 */
public class invoiceDAO {

    public invoiceDTO invoiceByUser(int contractID) {
        String sql = "SELECT c.[contractID], i.infoTitle, i.infoAddress, l.lendFullname, l.lendPhoneNumber ,\n"
                + "u.userFullname, u.userPhoneNumber ,[BookingDate],\n"
                + "[Checkin], [Checkout], [in].invoiceTotal , [contractStatus] FROM [dbo].[Contract] c \n"
                + "FULL JOIN [dbo].[Lendlord] l    ON c.lendID = l.lendID \n"
                + "FULL JOIN [dbo].[Information] i ON c.infoID = i.infoID \n"
                + "FULL JOIN [dbo].[Invoice] [in]	ON c.contractID = [in].invoiceID \n"
                + "FULL JOIN [dbo].[User] u		ON c.userID = u.userID\n"
                + "\n"
                + "where c.contractID = ?";
       try{
           Connection con = DBUtils.getConnection();
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, contractID);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               return new invoiceDTO(rs.getInt("contractID"), rs.getString("infoTitle"),rs.getString("infoAddress"), rs.getString("lendFullname"), rs.getString("lendPhoneNumber"),
                                      rs.getString("userFullname"), rs.getString("userPhoneNumber"), rs.getString("BookingDate"), rs.getString("Checkin"), rs.getString("Checkout"),
                                      rs.getFloat("invoiceTotal"), rs.getString("contractStatus"));
           }
       }catch(SQLException ex){
           ex.printStackTrace();
       }
       return null;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.DBUtils;

/**
 *
 * @author f1nn
 */
public class contractDAO {
    Connection con;
    public boolean cancelContractByUser(String contractID) {
        // TODO: implement method to delete a specific contract by ID
        
        String sql = "UPDATE  [dbo].[Contract] SET [contractStatus] = 'CANCELED' WHERE [contractID]  = ?";
        try {
            con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contractID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;// successfull cancellation of contract
            } else {
                System.out.println("No record found for given id");
                return false;// no records affected or no such user exists with that email address
            }
        } catch (SQLException sqle) {
        } finally {
            closeConnection(con);
        }
        return false;
    }

    private void closeConnection(Connection connection) {
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (Exception ignore) {
        }
    }

    }


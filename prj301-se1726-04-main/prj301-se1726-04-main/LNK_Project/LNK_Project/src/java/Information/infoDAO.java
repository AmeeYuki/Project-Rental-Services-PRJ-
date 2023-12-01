/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

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
public class infoDAO {

    private Connection connection;

    public List<infoDTO> getAllInfo() {
        List<infoDTO> infoList = new ArrayList<>();
        String query = "SELECT * FROM information";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                infoDTO info = new infoDTO(
                        resultSet.getString("lendID"),
                        resultSet.getString("couponID"),
                        resultSet.getString("infoTitle"),
                        resultSet.getString("infoAddress"),
                        resultSet.getString("infoType"),
                        resultSet.getString("infoTypeRoom"),
                        resultSet.getString("infoNumber"),
                        resultSet.getDouble("infoPrice"),
                        resultSet.getString("inforImage"),
                        resultSet.getString("infoDescription"),
                        resultSet.getString("uploadDate"),
                        resultSet.getString("infoStatus")
                );
                infoList.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return infoList;
    }

    public void insertInfo(infoDTO info) {
        String query = "INSERT INTO info_table (lendID, couponID, infoTitle, infoAddress, infoType, infoTypeRoom, infoNumber, "
                + "infoPrice, inforImage, infoDescription, uploadDate, infoStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, info.getLendID());
            statement.setString(2, info.getCouponID());
            statement.setString(3, info.getInfoTitle());
            statement.setString(4, info.getInfoAddress());
            statement.setString(5, info.getInfoType());
            statement.setString(6, info.getInfoTypeRoom());
            statement.setString(7, info.getInfoNumber());
            statement.setDouble(8, info.getInfoPrice());
            statement.setString(9, info.getInforImage());
            statement.setString(10, info.getInfoDescription());
            statement.setString(11, info.getUploadDate());
            statement.setString(12, info.getInfoStatus());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<infoDTO> getListPostisActive() {
        List<infoDTO> list = new ArrayList<>();
        String sql = "SELECT [infoTitle], [infoAddress], [infoType], [infoPrice], c.[couponDiscount], [infoNumber], i.[infoStatus]  FROM Information i FULL JOIN Coupon c ON c.couponID = i.couponID where [infoStatus] like 'a%' ORDER BY [infoNumber] ASC";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new infoDTO(rs.getString("infoTitle"), rs.getString("infoAddress"), rs.getString("infoType"), rs.getDouble("infoPrice"), rs.getFloat("couponDiscount")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<infoDTO> searchListPosBySearch(String keyword) {
        List<infoDTO> list = new ArrayList<>();
        String sql = "SELECT [infoTitle], [infoAddress], [infoType], [infoPrice], c.[couponDiscount], [infoNumber], i.[infoStatus]  FROM Information i FULL JOIN Coupon c ON c.couponID = i.couponID where [infoStatus] like 'a%' and [infoTitle] like ?  ORDER BY [infoNumber] ASC";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new infoDTO(rs.getString("infoTitle"), rs.getString("infoAddress"), rs.getString("infoType"), rs.getDouble("infoPrice"), rs.getFloat("couponDiscount")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<infoDTO> list() throws ClassNotFoundException {
        List<infoDTO> list = new ArrayList<>();
        String sql = "SELECT I.[infoID], I.[infoTitle], I.[uploadDate],L.[lendFullname] ,I.[infoStatus] FROM [dbo].[Information] I JOIN [dbo].[Lendlord] L ON I.[lendID] = L.[lendID]";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new infoDTO(rs.getInt("infoID"), rs.getString("infoTitle"), rs.getString("uploadDate"), rs.getString("lendFullname"), rs.getString("infoStatus")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<infoDTO> getInfoByID(int ID) throws ClassNotFoundException {
        List<infoDTO> list = new ArrayList<>();
        String sql = "SELECT I.[infoID], I.[infoTitle], I.[uploadDate],L.[lendFullname] ,I.[infoStatus] FROM [dbo].[Information] I JOIN [dbo].[Lendlord] L ON I.[lendID] = L.[lendID] WHERE I.[infoID] = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new infoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void delete(int ID) throws ClassNotFoundException {
        String sql = "UPDATE [dbo].[Information] SET [infoStatus] = 'Canceled' WHERE [infoID] = ? ";
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
        String sql = "UPDATE [dbo].[Information] SET [infoStatus] = 'Approved' WHERE [infoID] = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

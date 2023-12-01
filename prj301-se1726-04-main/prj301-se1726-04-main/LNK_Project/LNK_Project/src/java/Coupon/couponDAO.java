package Coupon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author f1nn
 */
public class couponDAO {

    public List<couponDTO> List() throws ClassNotFoundException {
        List<couponDTO> list = new ArrayList<>();
        String sql = "SELECT [couponID],[couponName], [startDate], [expiredDate], [couponStatus] FROM [dbo].[Coupon]";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new couponDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<couponDTO> getCouponByID(int ID) throws ClassNotFoundException {
        List<couponDTO> list2 = new ArrayList<>();
        String sql = "SELECT [couponID],[couponName], [startDate], [expiredDate], [couponStatus] FROM [dbo].[Coupon] WHERE [couponID] = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list2.add(new couponDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list2;
    }

    public int createCoupon(couponDTO coupon) {
        String sql = "INSERT INTO [dbo].[Coupon] ([couponName],[couponDetails],[couponDiscount],[couponFor],[startDate],[expiredDate],[couponStatus] ) VALUES (?,?,?,?,?,?,?)";
        int result = 0;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, coupon.getCouponName());
            ps.setString(2, coupon.getCouponDetails());
            ps.setFloat(3, coupon.getCouponDiscount());
            ps.setString(4, coupon.getCouponFor());
            ps.setString(5, coupon.getStartDate());
            ps.setString(6, coupon.getExpiredDate());
            ps.setString(7, coupon.getStatusCoupon());
            result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            System.err.println("SQL Exception in createCoupon: " + e.getMessage());
        }
        return result;
    }

    public void delete(int ID) throws ClassNotFoundException {
        String sql = "UPDATE [dbo].[Coupon] SET [couponStatus] = 'Canceled' WHERE [couponID] = ? ";
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
        String sql = "UPDATE [dbo].[Coupon] SET [couponStatus] = 'Approved' WHERE [couponID] = ? ";
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

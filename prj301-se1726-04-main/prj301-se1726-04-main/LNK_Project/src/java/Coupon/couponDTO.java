package Coupon;

import java.sql.Date;

/**
 *
 * @author f1nn
 */
public class couponDTO {

    private int couponID;
    private String couponName;
    private String couponDetails;
    private float couponDiscount;
    private String couponFor;
    private String startDate;
    private String expiredDate;
    private String couponStatus;

    public couponDTO() {
    }

    public couponDTO(int couponID, String couponName, String startDate, String expiredDate, String statusCoupon) {
        this.couponID = couponID;
        this.couponName = couponName;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.couponStatus = statusCoupon;
    }

    public couponDTO(int couponID, String couponName, String couponDetails, float couponDiscount, String couponFor, String startDate, String expiredDate, String statusCoupon) {
        this.couponID = couponID;
        this.couponName = couponName;
        this.couponDetails = couponDetails;
        this.couponDiscount = couponDiscount;
        this.couponFor = couponFor;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.couponStatus = statusCoupon;
    }

    public couponDTO(int couponID, String couponName, String couponDetails, String couponFor, String startDate, String expiredDate, String statusCoupon) {
        this.couponID = couponID;
        this.couponName = couponName;
        this.couponDetails = couponDetails;
        this.couponFor = couponFor;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.couponStatus = statusCoupon;
    }

    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponDetails() {
        return couponDetails;
    }

    public void setCouponDetails(String couponDetails) {
        this.couponDetails = couponDetails;
    }

    public float getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(float couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponFor() {
        return couponFor;
    }

    public void setCouponFor(String couponFor) {
        this.couponFor = couponFor;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStatusCoupon() {
        return couponStatus;
    }

    public void setStatusCoupon(String statusCoupon) {
        this.couponStatus = statusCoupon;
    }

    @Override
    public String toString() {
        return "couponDTO{" + "couponID=" + couponID + ", couponName=" + couponName + ", couponDetails=" + couponDetails + ", couponDiscount=" + couponDiscount + ", couponFor=" + couponFor + ", startDate=" + startDate + ", expiredDate=" + expiredDate + ", couponStatus=" + couponStatus + '}';
    }

}

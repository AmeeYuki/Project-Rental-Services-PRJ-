/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import Coupon.couponDTO;
import Lendlord.lendlordDTO;

/**
 *
 * @author f1nn
 */
public class infoDTO {

    private String lendID;
    private int infoID;
    private String couponID;
    private String infoTitle;
    private String infoAddress;
    private String infoType;
    private String infoTypeRoom;
    private String infoNumber;
    private double infoPrice;
    private String inforImage;
    private String infoDescription;
    private String uploadDate;
    private String infoStatus;
    private String lendFullname;
    private float couponDiscount;

    couponDTO coupon = new couponDTO();
    lendlordDTO lend = new lendlordDTO();

    public infoDTO() {
    }

    public infoDTO(String lendID, int infoID, String couponID, String infoTitle, String infoAddress, String infoType, String infoTypeRoom, String infoNumber, double infoPrice, String inforImage, String infoDescription, String uploadDate, String infoStatus) {
        this.lendID = lendID;
        this.infoID = infoID;
        this.couponID = couponID;
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.infoType = infoType;
        this.infoTypeRoom = infoTypeRoom;
        this.infoNumber = infoNumber;
        this.infoPrice = infoPrice;
        this.inforImage = inforImage;
        this.infoDescription = infoDescription;
        this.uploadDate = uploadDate;
        this.infoStatus = infoStatus;
    }

    public infoDTO(String lendID, String couponID, String infoTitle, String infoAddress, String infoType, String infoTypeRoom, String infoNumber, double infoPrice, String inforImage, String infoDescription, String uploadDate, String infoStatus) {
        this.lendID = lendID;
        this.infoID = infoID;
        this.couponID = couponID;
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.infoType = infoType;
        this.infoTypeRoom = infoTypeRoom;
        this.infoNumber = infoNumber;
        this.infoPrice = infoPrice;
        this.inforImage = inforImage;
        this.infoDescription = infoDescription;
        this.uploadDate = uploadDate;
        this.infoStatus = infoStatus;
    }

    public infoDTO(int infoID, String infoTitle, String uploadDate, String lendFullname, String infoStatus) {
        this.infoID = infoID;
        this.infoTitle = infoTitle;
        this.uploadDate = uploadDate;
        this.lendFullname = lendFullname;
        this.infoStatus = infoStatus;
    }

    public infoDTO(String infoTitle, String inforImage, String infoType, String infoAddress, float infoPrice) {
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.infoType = infoType;
        this.infoPrice = infoPrice;
        this.inforImage = inforImage;
    }

    public infoDTO(String infoTitle, String infoAddress, String infoType, double infoPrice, float couponDiscount) {
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.infoType = infoType;
        this.infoPrice = infoPrice;
        this.couponDiscount = couponDiscount;
    }

    public String getLendID() {
        return lendID;
    }

    public void setLendID(String lendID) {
        this.lendID = lendID;
    }

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoAddress() {
        return infoAddress;
    }

    public void setInfoAddress(String infoAddress) {
        this.infoAddress = infoAddress;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getInfoTypeRoom() {
        return infoTypeRoom;
    }

    public void setInfoTypeRoom(String infoTypeRoom) {
        this.infoTypeRoom = infoTypeRoom;
    }

    public String getInfoNumber() {
        return infoNumber;
    }

    public void setInfoNumber(String infoNumber) {
        this.infoNumber = infoNumber;
    }

    public double getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(double infoPrice) {
        this.infoPrice = infoPrice;
    }

    public String getInforImage() {
        return inforImage;
    }

    public void setInforImage(String inforImage) {
        this.inforImage = inforImage;
    }

    public String getInfoDescription() {
        return infoDescription;
    }

    public void setInfoDescription(String infoDescription) {
        this.infoDescription = infoDescription;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus;
    }

    public couponDTO getCoupon() {
        return coupon;
    }

    public void setCoupon(couponDTO coupon) {
        this.coupon = coupon;
    }

    public lendlordDTO getLend() {
        return lend;
    }

    public void setLend(lendlordDTO lend) {
        this.lend = lend;
    }

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public String getLendFullname() {
        return lendFullname;
    }

    public void setLendFullname(String lendFullname) {
        this.lendFullname = lendFullname;
    }

    public float getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(float couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    @Override
    public String toString() {
        return "infoDTO{" + "lendID=" + lendID + ", infoID=" + infoID + ", couponID=" + couponID + ", infoTitle=" + infoTitle + ", infoAddress=" + infoAddress + ", infoType=" + infoType + ", infoTypeRoom=" + infoTypeRoom + ", infoNumber=" + infoNumber + ", infoPrice=" + infoPrice + ", inforImage=" + inforImage + ", infoDescription=" + infoDescription + ", uploadDate=" + uploadDate + ", infoStatus=" + infoStatus + ", lendFullname=" + lendFullname + ", coupon=" + coupon + ", lend=" + lend + '}';
    }

}

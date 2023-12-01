/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import Coupon.couponDTO;
import Lendlord.lendlordDTO;
import java.sql.Date;

/**
 *
 * @author f1nn
 */
public class infoDTO {
    private int infoID;
    private String infoTitle;
    private String infoAddress;
    private String infoType;
    private String infoTypeRoom;
    private float infoPrice;
    private String infoNumber;
    private String inforImage;
    private String infoDecription;
    private Date uploadDate;
    private String infoStatus;

    couponDTO coupon = new couponDTO();
    lendlordDTO lend = new lendlordDTO();

    public infoDTO() {
    }

    public infoDTO(int infoID, String infoTitle, String infoAddress, String infoType, String infoTypeRoom, float infoPrice, String infoNumber, String inforImage, String infoDecription, Date uploadDate, String infoStatus) {
        this.infoID = infoID;
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.infoType = infoType;
        this.infoTypeRoom = infoTypeRoom;
        this.infoPrice = infoPrice;
        this.infoNumber = infoNumber;
        this.inforImage = inforImage;
        this.infoDecription = infoDecription;
        this.uploadDate = uploadDate;
        this.infoStatus = infoStatus;
    }
     public infoDTO(int infoID, String infoTitle, lendlordDTO lend, Date uploadDate, String infoStatus) {
        this.infoID = infoID;
        this.infoTitle = infoTitle;
        this.lend = lend;
        this.uploadDate = uploadDate;
        this.infoStatus = infoStatus;
    }

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
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

    public float getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(float infoPrice) {
        this.infoPrice = infoPrice;
    }

    public String getInfoNumber() {
        return infoNumber;
    }

    public void setInfoNumber(String infoNumber) {
        this.infoNumber = infoNumber;
    }

    public String getInforImage() {
        return inforImage;
    }

    public void setInforImage(String inforImage) {
        this.inforImage = inforImage;
    }

    public String getInfoDecription() {
        return infoDecription;
    }

    public void setInfoDecription(String infoDecription) {
        this.infoDecription = infoDecription;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
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

}
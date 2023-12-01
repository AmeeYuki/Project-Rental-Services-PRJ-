/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infomation;

import Coupon.couponDTO;
import Lendlord.lendlordDTO;

/**
 *
 * @author f1nn
 */
public class infoDTO {
    private Long infoID;
    private String infoTitle;
    private String infoAddress;
    private String infoDetails;
    private String infoFacility;
    private float infoPrice;
    private String infoType;
    
    couponDTO coupon = new couponDTO(); 
    lendlordDTO lend = new lendlordDTO();

    public infoDTO(){}
    
    
    public infoDTO(Long infoID, String infoTitle, String infoAddress, String infoDetails, String infoFacility, float infoPrice, String infoType) {
        this.infoID = infoID;
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.infoDetails = infoDetails;
        this.infoFacility = infoFacility;
        this.infoPrice = infoPrice;
        this.infoType = infoType;
    }

    public Long getInfoID() {
        return infoID;
    }

    public void setInfoID(Long infoID) {
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

    public String getInfoDetails() {
        return infoDetails;
    }

    public void setInfoDetails(String infoDetails) {
        this.infoDetails = infoDetails;
    }

    public String getInfoFacility() {
        return infoFacility;
    }

    public void setInfoFacility(String infoFacility) {
        this.infoFacility = infoFacility;
    }

    public float getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(float infoPrice) {
        this.infoPrice = infoPrice;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
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
 
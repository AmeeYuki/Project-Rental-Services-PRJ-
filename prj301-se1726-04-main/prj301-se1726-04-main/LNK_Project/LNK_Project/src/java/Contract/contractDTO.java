/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contract;

import Lendlord.lendlordDTO;
import User.userDTO;


/**
 *
 * @author f1nn
 */
public class contractDTO {
    private int contractID, infoID, lendID, userID;
    private String bookingDate, checkInDate, checkOutDate, contractStatus, infoTitle;
    
    lendlordDTO lend = new lendlordDTO();
    userDTO user = new userDTO();
    
    public contractDTO() {}

    public contractDTO(int contractID, int infoID,  int lendID, int userID,  String bookingDate, String checkInDate, String checkOutDate, String contractStatus) {
        this.userID = userID;
        this.lendID = lendID;
        this.infoID = infoID;
        this.contractID = contractID;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.contractStatus = contractStatus;
    }

    public contractDTO(int contractID, int infoID, String bookingDate, String checkInDate, String checkOutDate, String contractStatus, String infoTitle) {
        this.contractID = contractID;
        this.infoID = infoID;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.contractStatus = contractStatus;
        this.infoTitle = infoTitle;
    }
    
    

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public int getLendID() {
        return lendID;
    }

    public void setLendID(int lendID) {
        this.lendID = lendID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public lendlordDTO getLend() {
        return lend;
    }

    public void setLend(lendlordDTO lend) {
        this.lend = lend;
    }

    public userDTO getUser() {
        return user;
    }

    public void setUser(userDTO user) {
        this.user = user;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    @Override
    public String toString() {
        return "contractDTO{" + "contractID=" + contractID + ", infoID=" + infoID + ", lendID=" + lendID + ", userID=" + userID + ", bookingDate=" + bookingDate + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", contractStatus=" + contractStatus + ", infoTitle=" + infoTitle + ", lend=" + lend + ", user=" + user + '}';
    }

    public contractDTO(int contractID, String bookingDate, String checkInDate, String contractStatus, String infoTitle) {
        this.contractID = contractID;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.contractStatus = contractStatus;
        this.infoTitle = infoTitle;
    }

    
    

    
    
    
    
}

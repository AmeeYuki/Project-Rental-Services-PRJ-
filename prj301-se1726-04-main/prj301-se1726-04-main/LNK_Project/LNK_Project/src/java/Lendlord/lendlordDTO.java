/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendlord;



/**
 *
 * @author f1nn
 */
public class lendlordDTO {
    private int lendID;
    private String lendUsername, lendPassword, lendFullname, lendPhoneNumber, lendEmail;
    private float lendRating;

    public lendlordDTO(){}
    
    public lendlordDTO(int lendID, String lendUsername, String lendPassword, String lendFullname, String lendPhoneNumber, String lendEmail, float lendRating) {
        this.lendID = lendID;
        this.lendUsername = lendUsername;
        this.lendPassword = lendPassword;
        this.lendFullname = lendFullname;
        this.lendPhoneNumber = lendPhoneNumber;
        this.lendEmail = lendEmail;
        this.lendRating = lendRating;
    }

    public lendlordDTO (String lendUsername, String lendPassword, String lendEmail, String lendPhoneNumber) {
        this.lendUsername = lendUsername;
        this.lendPassword = lendPassword;
        this.lendEmail = lendEmail;
        this.lendPhoneNumber = lendPhoneNumber;
    }

    public int getLendID() {
        return lendID;
    }

    public void setLendID(int lendID) {
        this.lendID = lendID;
    }

    public String getLendUsername() {
        return lendUsername;
    }

    public void setLendUsername(String lendUsername) {
        this.lendUsername = lendUsername;
    }

    public String getLendPassword() {
        return lendPassword;
    }

    public void setLendPassword(String lendPassword) {
        this.lendPassword = lendPassword;
    }

    public String getLendFullname() {
        return lendFullname;
    }

    public void setLendFullname(String lendFullname) {
        this.lendFullname = lendFullname;
    }

    public String getLendPhoneNumber() {
        return lendPhoneNumber;
    }

    public void setLendPhoneNumber(String lendPhoneNumber) {
        this.lendPhoneNumber = lendPhoneNumber;
    }

    public String getLendEmail() {
        return lendEmail;
    }

    public void setLendEmail(String lendEmail) {
        this.lendEmail = lendEmail;
    }

    public float getLendRating() {
        return lendRating;
    }

    public void setLendRating(float lendRating) {
        this.lendRating = lendRating;
    }
    
    
    
    
}

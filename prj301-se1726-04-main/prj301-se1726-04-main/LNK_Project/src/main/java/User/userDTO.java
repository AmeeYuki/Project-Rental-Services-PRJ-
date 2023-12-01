/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;


/**
 *
 * @author f1nn
 */
public class userDTO {
    private int userID;
    private String userUsername, userPassword, userFullname, userPhoneNumber, userEmail;
    private int userRole;

    public userDTO(){}
    
    public userDTO(int userID, String userUsername, String userPassword, String userFullname, String userPhoneNumber, String userEmail, int userRole) {
        this.userID = userID;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userFullname = userFullname;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }
    
    public userDTO(String userUsername, String userPassword, String userEmail,String userPhoneNumber, int userRole){
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userPhoneNumber = userPhoneNumber;
    }

    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
    
    
    
    
}

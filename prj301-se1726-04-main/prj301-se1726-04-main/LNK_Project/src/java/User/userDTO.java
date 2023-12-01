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
    
    
    //test class LoginviaGoogle
    
    	private String id;

	private String email;

	private boolean verified_email;

	private String name;

	private String given_name;

	private String family_name;

	private String picture;

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

    public userDTO(String userUsername, String userEmail, int userRole) {
        this.userUsername = userUsername;
        this.userEmail = userEmail;
        this.userRole = userRole;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified_email() {
        return verified_email;
    }

    public void setVerified_email(boolean verified_email) {
        this.verified_email = verified_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getPicture() {
        return picture;
    }   

    public void setPicture(String picture) {
        this.picture = picture;
    }

    
    
    
    
    
//    @Override
//    public String toString() {
//        return "userDTO{" + "userID=" + userID + ", userUsername=" + userUsername + ", userPassword=" + userPassword + ", userFullname=" + userFullname + ", userPhoneNumber=" + userPhoneNumber + ", userEmail=" + userEmail + ", userRole=" + userRole + '}';
//    }

    @Override
    public String toString() {
        return "userDTO{" + "id=" + id + ", email=" + email + ", verified_email=" + verified_email + ", name=" + name + ", given_name=" + given_name + ", family_name=" + family_name + ", picture=" + picture + '}';
    }
    
    public userDTO(String userUsername, String userPassword, String userEmail,String userPhoneNumber){
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }
    
    
    
    
}

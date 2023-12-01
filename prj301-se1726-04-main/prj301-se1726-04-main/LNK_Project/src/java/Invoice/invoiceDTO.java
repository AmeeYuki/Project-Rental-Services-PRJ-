/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Invoice;

import Contract.contractDTO;


public class invoiceDTO {

    private int invoiceID;
    private float invoiceTotal;
    
    private int contractID;
    private String infoTitle;
    private String infoAddress;
    private String landName;
    private String landPhone;
    private String userName;
    private String userPhone;
    private String bookingDate;
    private String checkin;
    private String checkout;
    private String contractStatus;
    

    contractDTO contract = new contractDTO();

    public invoiceDTO(int invoiceID, float invoiceTotal) {
        this.invoiceID = invoiceID;
        this.invoiceTotal = invoiceTotal;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public float getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(float invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public contractDTO getContract() {
        return contract;
    }

    public void setContract(contractDTO contract) {
        this.contract = contract;
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

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getLandPhone() {
        return landPhone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public invoiceDTO(int contractID, String infoTitle, String infoAddress, String landName, String landPhone, String userName, String userPhone, String bookingDate, String checkin, String checkout,float invoiceTotal , String contractStatus ) {
        this.contractID = contractID;
        this.infoTitle = infoTitle;
        this.infoAddress = infoAddress;
        this.landName = landName;
        this.landPhone = landPhone;
        this.userName = userName;
        this.userPhone = userPhone;
        this.bookingDate = bookingDate;
        this.checkin = checkin;
        this.checkout = checkout;
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        return "invoiceDTO{" + "invoiceID=" + invoiceID + ", invoiceTotal=" + invoiceTotal + ", contractID=" + contractID + ", infoTitle=" + infoTitle + ", infoAddress=" + infoAddress + ", landName=" + landName + ", landPhone=" + landPhone + ", userName=" + userName + ", userPhone=" + userPhone + ", bookingDate=" + bookingDate + ", checkin=" + checkin + ", checkout=" + checkout + ", contractStatus=" + contractStatus + ", contract=" + contract + '}';
    }
    
    
    
}

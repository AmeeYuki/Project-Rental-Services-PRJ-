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

}

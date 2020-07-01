/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.common;

/**
 *
 * @author dell
 */
public class CustomerClientBean {
    
    private Integer id;
     private BillBean bills;
     private CustomerBean customer;
     private SellBean sell;

    public CustomerClientBean() {
    }

     
    public CustomerClientBean(Integer id, BillBean bills, CustomerBean customer, SellBean sell) {
        this.id = id;
        this.bills = bills;
        this.customer = customer;
        this.sell = sell;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BillBean getBills() {
        return bills;
    }

    public void setBills(BillBean bills) {
        this.bills = bills;
    }

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    public SellBean getSell() {
        return sell;
    }

    public void setSell(SellBean sell) {
        this.sell = sell;
    }
     
     
}

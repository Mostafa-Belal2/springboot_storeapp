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
public class CustomerSupplierBean {

    private Integer id;
    private BillBean bills;
    private BuyBean buy;
    private SupplierBean supplier;

    public CustomerSupplierBean() {
    }

    
    public CustomerSupplierBean(Integer id, BillBean bills, BuyBean buy, SupplierBean supplier) {
        this.id = id;
        this.bills = bills;
        this.buy = buy;
        this.supplier = supplier;
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

    public BuyBean getBuy() {
        return buy;
    }

    public void setBuy(BuyBean buy) {
        this.buy = buy;
    }

    public SupplierBean getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierBean supplier) {
        this.supplier = supplier;
    }

}

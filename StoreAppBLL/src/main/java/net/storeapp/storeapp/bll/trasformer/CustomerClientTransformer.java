/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.CustomerClientBean;
import net.storeapp.storeapp.dal.entity.CustomerClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class CustomerClientTransformer implements CommonTransformer<CustomerClientEntity, CustomerClientBean> {

    @Autowired
    BillTransformer bt;
    
    @Autowired
    CustomerTransformer ct;
    
    @Autowired
    SellTransformer st;
    
    @Override
    public CustomerClientBean fromEntityToBean(CustomerClientEntity entity) {
        CustomerClientBean bean = new CustomerClientBean();
        bean.setId(entity.getId());
        bean.setBills(bt.fromEntityToBean(entity.getBills()));
        bean.setCustomer(ct.fromEntityToBean(entity.getCustomer()));
        bean.setSell(st.fromEntityToBean(entity.getSell()));
        return bean;
    }

    @Override
    public CustomerClientEntity fromBeanToEntity(CustomerClientBean bean) {
        CustomerClientEntity entity = new CustomerClientEntity();
        entity.setId(bean.getId());
        entity.setBills(bt.fromBeanToEntity(bean.getBills()));
        entity.setCustomer(ct.fromBeanToEntity(bean.getCustomer()));
        entity.setSell(st.fromBeanToEntity(bean.getSell()));
        return entity;
    }
// <editor-fold defaultstate="collapsed" desc=" GETTERS&SETTERS ">

    public BillTransformer getBt() {
        return bt;
    }

    public void setBt(BillTransformer bt) {
        this.bt = bt;
    }

    public CustomerTransformer getCt() {
        return ct;
    }

    public void setCt(CustomerTransformer ct) {
        this.ct = ct;
    }

    public SellTransformer getSt() {
        return st;
    }

    public void setSt(SellTransformer st) {
        this.st = st;
    }

    // </editor-fold>

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.CustomerSupplierBean;
import net.storeapp.storeapp.dal.entity.CustomerSupplierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class CustomerSupplierTransformer implements CommonTransformer<CustomerSupplierEntity, CustomerSupplierBean> {

    @Autowired
    BillTransformer bt;
    
    @Autowired
    SupplierTransformer st;
    
    @Autowired
    BuyTransformer btr;
    
    @Override
    public CustomerSupplierBean fromEntityToBean(CustomerSupplierEntity entity) {
        CustomerSupplierBean bean = new CustomerSupplierBean();
        bean.setId(entity.getId());
        bean.setBills(bt.fromEntityToBean(entity.getBills()));
        bean.setSupplier(st.fromEntityToBean(entity.getSupplier()));
        bean.setBuy(btr.fromEntityToBean(entity.getBuy()));
        return bean;
    }

    @Override
    public CustomerSupplierEntity fromBeanToEntity(CustomerSupplierBean bean) {
        CustomerSupplierEntity entity = new CustomerSupplierEntity();
        entity.setId(bean.getId());
        entity.setBills(bt.fromBeanToEntity(bean.getBills()));
        entity.setSupplier(st.fromBeanToEntity(bean.getSupplier()));
        entity.setBuy(btr.fromBeanToEntity(bean.getBuy()));
        return entity;
    }
// <editor-fold defaultstate="collapsed" desc=" GETTERS&SETTERS ">

    public BillTransformer getBt() {
        return bt;
    }

    public void setBt(BillTransformer bt) {
        this.bt = bt;
    }

    public SupplierTransformer getSt() {
        return st;
    }

    public void setSt(SupplierTransformer st) {
        this.st = st;
    }

    public BuyTransformer getBtr() {
        return btr;
    }

    public void setBtr(BuyTransformer btr) {
        this.btr = btr;
    }

// </editor-fold>
    
}

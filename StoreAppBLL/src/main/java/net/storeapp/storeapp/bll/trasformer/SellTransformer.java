/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.SellBean;
import net.storeapp.storeapp.dal.entity.SellEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class SellTransformer implements CommonTransformer<SellEntity, SellBean> {

    @Autowired
    CategoryTransformer ct;

    @Autowired
    SizeTransformer st;

    @Override
    public SellBean fromEntityToBean(SellEntity entity) {
        SellBean bean = new SellBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setPrice(entity.getPrice());
        bean.setQuantity(entity.getQuantity());
        bean.setSize(st.fromEntityToBean(entity.getSize()));
        bean.setCategory(ct.fromEntityToBean(entity.getCategory()));
        bean.setDate(entity.getDate());
        bean.setTime(entity.getTime());
        return bean;
    }

    @Override
    public SellEntity fromBeanToEntity(SellBean bean) {
        SellEntity entity = new SellEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        entity.setPrice(bean.getPrice());
        entity.setQuantity(bean.getQuantity());
        entity.setSize(st.fromBeanToEntity(bean.getSize()));
        entity.setCategory(ct.fromBeanToEntity(bean.getCategory()));
        entity.setDate(bean.getDate());
        entity.setTime(bean.getTime());
        return entity;
    }
// <editor-fold defaultstate="collapsed" desc=" GETTERS&SETTERS ">
    public CategoryTransformer getCt() {
        return ct;
    }

    public void setCt(CategoryTransformer ct) {
        this.ct = ct;
    }

    public SizeTransformer getSt() {
        return st;
    }

    public void setSt(SizeTransformer st) {
        this.st = st;
    }
// </editor-fold>

}
 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.DamageBean;
import net.storeapp.storeapp.dal.entity.DamageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class DamageTransformer implements CommonTransformer<DamageEntity, DamageBean> {

    @Autowired
    CategoryTransformer ct;

    @Autowired
    SizeTransformer st;

    @Override
    public DamageBean fromEntityToBean(DamageEntity entity) {
        DamageBean bean = new DamageBean();
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
    public DamageEntity fromBeanToEntity(DamageBean bean) {
        DamageEntity entity = new DamageEntity();
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

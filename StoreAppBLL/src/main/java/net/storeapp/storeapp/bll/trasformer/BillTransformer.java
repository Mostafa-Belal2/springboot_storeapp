/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.BillBean;
import net.storeapp.storeapp.dal.entity.BillEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class BillTransformer implements CommonTransformer<BillEntity, BillBean> {

    @Override
    public BillBean fromEntityToBean(BillEntity entity) {
        BillBean bean = new BillBean();
        bean.setId(entity.getId());
        bean.setType(entity.getType());
        bean.setDetails(entity.getDetails());
        bean.setPay(entity.getPay());
        bean.setReminder(entity.getReminder());
        bean.setTotalCost(entity.getTotalCost());
        bean.setStartDate(entity.getStartDate());
        bean.setEndDate(entity.getEndDate());
        bean.setTime(entity.getTime());
        return bean;
    }

    @Override
    public BillEntity fromBeanToEntity(BillBean bean) {
        BillEntity entity = new BillEntity();
        entity.setId(bean.getId());
        entity.setType(bean.getType());
        entity.setDetails(bean.getDetails());
        entity.setPay(bean.getPay());
        entity.setReminder(bean.getReminder());
        entity.setTotalCost(bean.getTotalCost());
        entity.setStartDate(bean.getStartDate());
        entity.setEndDate(bean.getEndDate());
        entity.setTime(bean.getTime());
        return entity;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.CostBean;
import net.storeapp.storeapp.dal.entity.CostEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class CostTransformer implements CommonTransformer<CostEntity, CostBean> {

    @Override
    public CostBean fromEntityToBean(CostEntity entity) {
        CostBean bean = new CostBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setPrice(entity.getPrice());
        bean.setDetails(entity.getDetails());
        bean.setDate(entity.getDate());
        bean.setTime(entity.getTime());
        return bean;
    }

    @Override
    public CostEntity fromBeanToEntity(CostBean bean) {
        CostEntity entity = new CostEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        entity.setPrice(bean.getPrice());
        entity.setDetails(bean.getDetails());
        entity.setDate(bean.getDate());
        entity.setTime(bean.getTime());
        return entity;
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.SizeBean;
import net.storeapp.storeapp.dal.entity.SizeEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class SizeTransformer implements CommonTransformer<SizeEntity, SizeBean> {

    @Override
    public SizeBean fromEntityToBean(SizeEntity entity) {
        SizeBean bean = new SizeBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        return bean;
    }

    @Override
    public SizeEntity fromBeanToEntity(SizeBean bean) {
        SizeEntity entity = new SizeEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        return entity;
    } 
    
}

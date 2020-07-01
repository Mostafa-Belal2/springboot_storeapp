/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.SupplierBean;
import net.storeapp.storeapp.dal.entity.SupplierEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class SupplierTransformer implements CommonTransformer<SupplierEntity, SupplierBean> {

    @Override
    public SupplierBean fromEntityToBean(SupplierEntity entity) {
        SupplierBean bean = new SupplierBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        return bean;
    }

    @Override
    public SupplierEntity fromBeanToEntity(SupplierBean bean) {
        SupplierEntity entity = new SupplierEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        return entity;
    } 
    
}

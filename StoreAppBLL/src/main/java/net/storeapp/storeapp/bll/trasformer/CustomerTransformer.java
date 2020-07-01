/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.CustomerBean;
import net.storeapp.storeapp.dal.entity.CustomerEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class CustomerTransformer implements CommonTransformer<CustomerEntity, CustomerBean> {

    @Override
    public CustomerBean fromEntityToBean(CustomerEntity entity) {
        CustomerBean bean = new CustomerBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        return bean;
    }

    @Override
    public CustomerEntity fromBeanToEntity(CustomerBean bean) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        return entity;
    } 
    
}

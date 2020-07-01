/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.BorrowBean;
import net.storeapp.storeapp.dal.entity.BorrowEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class BorrowTransformer implements CommonTransformer<BorrowEntity, BorrowBean> {

    @Override
    public BorrowBean fromEntityToBean(BorrowEntity entity) {
        BorrowBean bean = new BorrowBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setPrice(entity.getPrice());
        bean.setDetails(entity.getDetails());
        bean.setDate(entity.getDate());
        bean.setTime(entity.getTime());
        return bean;
    }

    @Override
    public BorrowEntity fromBeanToEntity(BorrowBean bean) {
        BorrowEntity entity = new BorrowEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        entity.setPrice(bean.getPrice());
        entity.setDetails(bean.getDetails());
        entity.setDate(bean.getDate());
        entity.setTime(bean.getTime());
        return entity;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.CategoryBean;
import net.storeapp.storeapp.dal.entity.CategoryEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class CategoryTransformer implements CommonTransformer<CategoryEntity, CategoryBean> {

    @Override
    public CategoryBean fromEntityToBean(CategoryEntity entity) {
        CategoryBean bean = new CategoryBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        return bean;
    }

    @Override
    public CategoryEntity fromBeanToEntity(CategoryBean bean) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        return entity;
    } 
    
}


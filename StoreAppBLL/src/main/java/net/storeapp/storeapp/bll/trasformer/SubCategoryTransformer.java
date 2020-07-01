/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.SubCategoryBean;
import net.storeapp.storeapp.dal.entity.SubCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class SubCategoryTransformer implements CommonTransformer<SubCategoryEntity, SubCategoryBean> {

    @Autowired
    CategoryTransformer categoryTransformer;
    
    @Override
    public SubCategoryBean fromEntityToBean(SubCategoryEntity entity) {
        SubCategoryBean bean = new SubCategoryBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setCategoryBean(categoryTransformer.fromEntityToBean(entity.getCategory()));
        return bean;
    }

    @Override
    public SubCategoryEntity fromBeanToEntity(SubCategoryBean bean) {
        SubCategoryEntity entity = new SubCategoryEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        entity.setCategory(categoryTransformer.fromBeanToEntity(bean.getCategoryBean()));
        return entity;
    } 

    public CategoryTransformer getCategoryTransformer() {
        return categoryTransformer;
    }

    public void setCategoryTransformer(CategoryTransformer categoryTransformer) {
        this.categoryTransformer = categoryTransformer;
    }
    
    
    
}


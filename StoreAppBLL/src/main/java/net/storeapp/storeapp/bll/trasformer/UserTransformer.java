/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

import net.storeapp.storeapp.common.UserBean;
import net.storeapp.storeapp.dal.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component
public class UserTransformer implements CommonTransformer<UserEntity, UserBean> {

    @Override
    public UserBean fromEntityToBean(UserEntity entity) {
        UserBean bean = new UserBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setPassword(entity.getPassword());
        bean.setRole(entity.getRole());
        return bean;
    }

    @Override
    public UserEntity fromBeanToEntity(UserBean bean) {
        UserEntity entity = new UserEntity();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        entity.setPassword(bean.getPassword());
        entity.setRole(bean.getRole());
        return entity;
    }

}

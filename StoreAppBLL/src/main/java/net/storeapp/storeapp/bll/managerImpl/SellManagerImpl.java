/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.managerImpl;

import java.util.ArrayList;
import java.util.List;
import net.storeapp.storeapp.bll.manager.SellManager;
import net.storeapp.storeapp.bll.trasformer.SellTransformer;
import net.storeapp.storeapp.common.SellBean;
import net.storeapp.storeapp.dal.entity.SellEntity;
import net.storeapp.storeapp.dal.repo.SellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Transactional
@Service
public class SellManagerImpl implements SellManager {

    @Autowired
    SellTransformer sellTransformer;

    @Autowired
    SellRepo sr;

    @Override
    public SellBean addSell(SellBean userBean) {
        SellEntity entity = sellTransformer.fromBeanToEntity(userBean);
        entity = sr.add(entity);
        userBean = sellTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public SellBean updateSell(SellBean userBean) {
        SellEntity entity = sellTransformer.fromBeanToEntity(userBean);
        entity = sr.update(entity);
        userBean = sellTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public void removeSell(Integer id) {
        sr.remove(id);
    }

    @Override
    public SellBean findSellById(Integer id) {
        SellBean bean = sellTransformer.fromEntityToBean(sr.findById(id));
        return bean;
    }

    @Override
    public List<SellBean> listSell() {
        List<SellBean> listSells = new ArrayList<>();
        List<SellEntity> users = sr.findList();
        for (SellEntity user : users) {
            listSells.add(sellTransformer.fromEntityToBean(user));
        }
        return listSells;
    }

}

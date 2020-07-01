/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.managerImpl;

import java.util.ArrayList;
import java.util.List;
import net.storeapp.storeapp.bll.manager.ReturnManager;
import net.storeapp.storeapp.bll.trasformer.DamageTransformer;
import net.storeapp.storeapp.bll.trasformer.ReturnTransformer;
import net.storeapp.storeapp.common.DamageBean;
import net.storeapp.storeapp.common.ReturnBean;
import net.storeapp.storeapp.dal.entity.DamageEntity;
import net.storeapp.storeapp.dal.entity.ReturnEntity;
import net.storeapp.storeapp.dal.repo.DamageRepo;
import net.storeapp.storeapp.dal.repo.ReturnsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Transactional
@Service
public class ReturnManagerImpl implements ReturnManager {

    @Autowired
    ReturnTransformer returnTransformer;

    @Autowired
    ReturnsRepo rr;

    @Autowired
    DamageTransformer damageTransformer;

    @Autowired
    DamageRepo dr;

    @Override
    public ReturnBean addReturn(ReturnBean returnBean) {
        ReturnEntity entity = returnTransformer.fromBeanToEntity(returnBean);
        entity = rr.add(entity);
        returnBean = returnTransformer.fromEntityToBean(entity);
        return returnBean;
    }

    @Override
    public ReturnBean updateReturn(ReturnBean returnBean) {
        ReturnEntity entity = returnTransformer.fromBeanToEntity(returnBean);
        entity = rr.update(entity);
        returnBean = returnTransformer.fromEntityToBean(entity);
        return returnBean;
    }

    @Override
    public void removeReturn(Integer id) {
        rr.remove(id);
    }

    @Override
    public ReturnBean findReturnById(Integer id) {
        ReturnBean bean = returnTransformer.fromEntityToBean(rr.findById(id));
        return bean;
    }

    @Override
    public List<ReturnBean> listReturn() {
        List<ReturnBean> listReturns = new ArrayList<>();
        List<ReturnEntity> users = rr.findList();
        for (ReturnEntity user : users) {
            listReturns.add(returnTransformer.fromEntityToBean(user));
        }
        return listReturns;
    }

    @Override
    public DamageBean addDamage(DamageBean userBean) {
        DamageEntity entity = damageTransformer.fromBeanToEntity(userBean);
        entity = dr.add(entity);
        userBean = damageTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public DamageBean updateDamage(DamageBean userBean) {
        DamageEntity entity = damageTransformer.fromBeanToEntity(userBean);
        entity = dr.update(entity);
        userBean = damageTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public void removeDamage(Integer id) {
        dr.remove(id);
    }

    @Override
    public DamageBean findDamageById(Integer id) {
        DamageBean bean = damageTransformer.fromEntityToBean(dr.findById(id));
        return bean;
    }

    @Override
    public List<DamageBean> listDamage() {
        List<DamageBean> listDamages = new ArrayList<>();
        List<DamageEntity> users = dr.findList();
        for (DamageEntity user : users) {
            listDamages.add(damageTransformer.fromEntityToBean(user));
        }
        return listDamages;
    }
}

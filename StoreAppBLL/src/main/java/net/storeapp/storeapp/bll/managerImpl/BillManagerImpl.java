/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.managerImpl;

import java.util.ArrayList;
import java.util.List;
import net.storeapp.storeapp.bll.manager.BillManager;
import net.storeapp.storeapp.bll.trasformer.BillTransformer;
import net.storeapp.storeapp.common.BillBean;
import net.storeapp.storeapp.dal.entity.BillEntity;
import net.storeapp.storeapp.dal.repo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Transactional
@Service
public class BillManagerImpl implements BillManager{
    
        
    @Autowired
    BillTransformer BillTransformer;
    
    @Autowired
    BillRepo br;
    
    @Override
    public BillBean addBill(BillBean userBean) {
        BillEntity entity = BillTransformer.fromBeanToEntity(userBean);
        entity = br.add(entity);
        userBean = BillTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public BillBean updateBill(BillBean userBean) {
        BillEntity entity = BillTransformer.fromBeanToEntity(userBean);
        entity = br.update(entity);
        userBean = BillTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public void removeBill(Integer id) {
        br.remove(id);
    }

    @Override
    public BillBean findBillById(Integer id) {
        BillBean bean = BillTransformer.fromEntityToBean(br.findById(id));
        return bean;
    }

    @Override
    public List<BillBean> listBill() {
        List<BillBean> listBills = new ArrayList<>();
        List<BillEntity> users = br.findList();
        for (BillEntity user : users) {
            listBills.add(BillTransformer.fromEntityToBean(user));
        }
        return listBills;
    }
}

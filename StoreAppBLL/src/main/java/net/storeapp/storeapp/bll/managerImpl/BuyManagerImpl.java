/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.managerImpl;

import java.util.ArrayList;
import java.util.List;
import net.storeapp.storeapp.bll.manager.BuyManager;
import net.storeapp.storeapp.bll.trasformer.BuyTransformer;
import net.storeapp.storeapp.common.BuyBean;
import net.storeapp.storeapp.dal.entity.BuyEntity;
import net.storeapp.storeapp.dal.repo.BuyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Transactional
@Service
public class BuyManagerImpl implements BuyManager {

    @Autowired
    BuyTransformer buyTransformer;

    @Autowired
    BuyRepo br;

    @Override
    public BuyBean addBuy(BuyBean userBean) {
        BuyEntity entity = buyTransformer.fromBeanToEntity(userBean);
        entity = br.add(entity);
        userBean = buyTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public BuyBean updateBuy(BuyBean userBean) {
        BuyEntity entity = buyTransformer.fromBeanToEntity(userBean);
        entity = br.update(entity);
        userBean = buyTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public void removeBuy(Integer id) {
        br.remove(id);
    }

    @Override
    public BuyBean findBuyById(Integer id) {
        BuyBean bean = buyTransformer.fromEntityToBean(br.findById(id));
        return bean;
    }

    @Override
    public List<BuyBean> listBuy() {
        List<BuyBean> listBuys = new ArrayList<>();
        List<BuyEntity> users = br.findList();
        for (BuyEntity user : users) {
            listBuys.add(buyTransformer.fromEntityToBean(user));
        }
        return listBuys;
    }
}

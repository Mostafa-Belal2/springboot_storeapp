/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.manager;

import java.util.List;
import net.storeapp.storeapp.common.BuyBean;

/**
 *
 * @author dell
 */
public interface BuyManager {

    public List<BuyBean> listBuy();

    public BuyBean findBuyById(Integer id);

    public BuyBean addBuy(BuyBean buyBean);

    public BuyBean updateBuy(BuyBean buyBean);

    public void removeBuy(Integer id);
}

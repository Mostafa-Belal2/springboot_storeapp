/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.manager;

import java.util.List;
import net.storeapp.storeapp.common.SellBean;

/**
 *
 * @author dell
 */
public interface SellManager {
    
    public List<SellBean> listSell();

    public SellBean findSellById(Integer id);

    public SellBean addSell(SellBean sellBean);

    public SellBean updateSell(SellBean sellBean);

    public void removeSell(Integer id);
}

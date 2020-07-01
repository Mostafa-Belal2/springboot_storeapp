/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.manager;

import java.util.List;
import net.storeapp.storeapp.common.BillBean;

/**
 *
 * @author dell
 */
public interface BillManager {

    public List<BillBean> listBill();

    public BillBean findBillById(Integer id);

    public BillBean addBill(BillBean buyBean);

    public BillBean updateBill(BillBean buyBean);

    public void removeBill(Integer id);
}

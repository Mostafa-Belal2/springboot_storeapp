/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll;

import java.util.List;
import net.storeapp.storeapp.bll.manager.BillManager;
import net.storeapp.storeapp.bll.manager.BuyManager;
import net.storeapp.storeapp.bll.manager.LockupsManager;
import net.storeapp.storeapp.bll.manager.ReturnManager;
import net.storeapp.storeapp.bll.manager.SellManager;
import net.storeapp.storeapp.common.BillBean;
import net.storeapp.storeapp.common.BorrowBean;
import net.storeapp.storeapp.common.BuyBean;
import net.storeapp.storeapp.common.CategoryBean;
import net.storeapp.storeapp.common.CostBean;
import net.storeapp.storeapp.common.CustomerBean;
import net.storeapp.storeapp.common.DamageBean;
import net.storeapp.storeapp.common.ReturnBean;
import net.storeapp.storeapp.common.SellBean;
import net.storeapp.storeapp.common.SizeBean;
import net.storeapp.storeapp.common.SubCategoryBean;
import net.storeapp.storeapp.common.SupplierBean;
import net.storeapp.storeapp.common.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class BllGateway {

    @Autowired
    BillManager billManager;
    @Autowired
    BuyManager buyManager;
    @Autowired
    LockupsManager lockupsManager;
    @Autowired
    ReturnManager returnManager;
    @Autowired
    SellManager sellManager;

    public List<BillBean> listBill() {
        return billManager.listBill();
    }

    public BillBean findBillById(Integer id) {
        return billManager.findBillById(id);
    }

    public BillBean addBill(BillBean buyBean) {
        return billManager.addBill(buyBean);
    }

    public BillBean updateBill(BillBean buyBean) {
        return billManager.updateBill(buyBean);
    }

    public void removeBill(Integer id) {
        billManager.removeBill(id);
    }

    public List<BuyBean> listBuy() {
        return buyManager.listBuy();
    }

    public BuyBean findBuyById(Integer id) {
        return buyManager.findBuyById(id);
    }

    public BuyBean addBuy(BuyBean buyBean) {
        return buyManager.addBuy(buyBean);
    }

    public BuyBean updateBuy(BuyBean buyBean) {
        return buyManager.updateBuy(buyBean);
    }

    public void removeBuy(Integer id) {
        buyManager.removeBuy(id);
    }

    public UserBean addUser(UserBean usersBean) {
        return lockupsManager.addUser(usersBean);
    }

    public UserBean updateUser(UserBean usersBean) {
        return lockupsManager.updateUser(usersBean);
    }

    public void removeUser(Integer id) {
        lockupsManager.removeUser(id);
    }

    public UserBean findUserById(Integer id) {
        return lockupsManager.findUserById(id);
    }

    public List<UserBean> listUsers() {
        return lockupsManager.listUsers();
    }

    public CustomerBean addCustomer(CustomerBean customerBean) {
        return lockupsManager.addCustomer(customerBean);
    }

    public CustomerBean updateCustomer(CustomerBean customerBean) {
        return lockupsManager.updateCustomer(customerBean);
    }

    public void removeCustomer(Integer id) {
        lockupsManager.removeCustomer(id);
    }

    public CustomerBean findCustomerById(Integer id) {
        return lockupsManager.findCustomerById(id);
    }

    public List<CustomerBean> listCustomers() {
        return lockupsManager.listCustomers();
    }

    public SupplierBean addSupplier(SupplierBean supplierBean) {
        return lockupsManager.addSupplier(supplierBean);
    }

    public SupplierBean updateSupplier(SupplierBean supplierBean) {
        return lockupsManager.updateSupplier(supplierBean);
    }

    public void removeSupplier(Integer id) {
        lockupsManager.removeSupplier(id);
    }

    public SupplierBean findSupplierById(Integer id) {
        return lockupsManager.findSupplierById(id);
    }

    public List<SupplierBean> listSupplier() {
        return lockupsManager.listSupplier();
    }

    public CategoryBean addCategory(CategoryBean categoryBean) {
        return lockupsManager.addCategory(categoryBean);
    }

    public CategoryBean updateCategory(CategoryBean categoryBean) {
        return lockupsManager.updateCategory(categoryBean);
    }

    public void removeCategory(Integer id) {
        lockupsManager.removeCategory(id);
    }

    public CategoryBean findCategoryById(Integer id) {
        return lockupsManager.findCategoryById(id);
    }

    public CategoryBean findCategoryByName(String name) {
        return lockupsManager.findCategoryByName(name);
    }

    public List<CategoryBean> listCategory() {
        return lockupsManager.listCategory();
    }

    public SizeBean addSize(SizeBean sizeBean) {
        return lockupsManager.addSize(sizeBean);
    }

    public SizeBean updateSize(SizeBean sizeBean) {
        return lockupsManager.updateSize(sizeBean);
    }

    public void removeSize(Integer id) {
        lockupsManager.removeSize(id);
    }

    public SizeBean findSizeById(Integer id) {
        return lockupsManager.findSizeById(id);
    }

    public List<SizeBean> listSize() {
        return lockupsManager.listSize();
    }

    public CostBean addCost(CostBean costBean) {
        return lockupsManager.addCost(costBean);
    }

    public CostBean updateCost(CostBean costBean) {
        return lockupsManager.updateCost(costBean);
    }

    public void removeCost(Integer id) {
        lockupsManager.removeCost(id);
    }

    public CostBean findCostById(Integer id) {
        return lockupsManager.findCostById(id);
    }

    public List<CostBean> listCost() {
        return lockupsManager.listCost();
    }

    public BorrowBean addBorrow(BorrowBean BorrowBean) {
        return lockupsManager.addBorrow(BorrowBean);
    }

    public BorrowBean updateBorrow(BorrowBean borrowBean) {
        return lockupsManager.updateBorrow(borrowBean);
    }

    public void removeBorrow(Integer id) {
        lockupsManager.removeBorrow(id);
    }

    public BorrowBean findBorrowById(Integer id) {
        return lockupsManager.findBorrowById(id);
    }

    public List<BorrowBean> listBorrow() {
        return lockupsManager.listBorrow();
    }

    public List<ReturnBean> listReturn() {
        return returnManager.listReturn();
    }

    public ReturnBean findReturnById(Integer id) {
        return returnManager.findReturnById(id);
    }

    public ReturnBean addReturn(ReturnBean returnsBean) {
        return returnManager.addReturn(returnsBean);
    }

    public ReturnBean updateReturn(ReturnBean returnsBean) {
        return returnManager.updateReturn(returnsBean);
    }

    public void removeReturn(Integer id) {
        returnManager.removeReturn(id);
    }

    public List<DamageBean> listDamage() {
        return returnManager.listDamage();
    }

    public DamageBean findDamageById(Integer id) {
        return returnManager.findDamageById(id);
    }

    public DamageBean addDamage(DamageBean damageBean) {
        return returnManager.addDamage(damageBean);
    }

    public DamageBean updateDamage(DamageBean damageBean) {
        return returnManager.updateDamage(damageBean);
    }

    public void removeDamage(Integer id) {
        returnManager.removeDamage(id);
    }

    public List<SellBean> listSell() {
        return sellManager.listSell();
    }

    public SellBean findSellById(Integer id) {
        return sellManager.findSellById(id);
    }

    public SellBean addSell(SellBean sellBean) {
        return sellManager.addSell(sellBean);
    }

    public SellBean updateSell(SellBean sellBean) {
        return sellManager.updateSell(sellBean);
    }

    public void removeSell(Integer id) {
        sellManager.removeSell(id);
    }

    public SubCategoryBean addSubCategory(SubCategoryBean subCategoryBean) {
        return lockupsManager.addSubCategory(subCategoryBean);
    }

    public SubCategoryBean updateSubCategory(SubCategoryBean subCategoryBean) {
        return lockupsManager.updateSubCategory(subCategoryBean);
    }

    public void removeSubCategory(Integer id) {
        lockupsManager.removeSubCategory(id);
    }

    public SubCategoryBean findSubCategoryById(Integer id) {
        return lockupsManager.findSubCategoryById(id);
    }

    public List<SubCategoryBean> listSubCategory() {
        return lockupsManager.listSubCategory();
    }

}

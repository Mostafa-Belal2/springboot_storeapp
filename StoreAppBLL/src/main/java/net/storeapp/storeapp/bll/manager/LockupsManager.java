/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.manager;

import java.util.List;
import net.storeapp.storeapp.common.BorrowBean;
import net.storeapp.storeapp.common.CategoryBean;
import net.storeapp.storeapp.common.CostBean;
import net.storeapp.storeapp.common.CustomerBean;
import net.storeapp.storeapp.common.SizeBean;
import net.storeapp.storeapp.common.SubCategoryBean;
import net.storeapp.storeapp.common.SupplierBean;
import net.storeapp.storeapp.common.UserBean;

/**
 *
 * @author dell
 */
public interface LockupsManager {

    //User
    public UserBean addUser(UserBean usersBean);

    public UserBean updateUser(UserBean usersBean);

    public void removeUser(Integer id);

    public UserBean findUserById(Integer id);

    public List<UserBean> listUsers();

    //Customer
    public CustomerBean addCustomer(CustomerBean customerBean);

    public CustomerBean updateCustomer(CustomerBean customerBean);

    public void removeCustomer(Integer id);

    public CustomerBean findCustomerById(Integer id);

    public List<CustomerBean> listCustomers();

    //Supplier
    public SupplierBean addSupplier(SupplierBean supplierBean);

    public SupplierBean updateSupplier(SupplierBean supplierBean);

    public void removeSupplier(Integer id);

    public SupplierBean findSupplierById(Integer id);

    public List<SupplierBean> listSupplier();

    //Category
    public CategoryBean addCategory(CategoryBean categoryBean);

    public CategoryBean updateCategory(CategoryBean categoryBean);

    public void removeCategory(Integer id);

    public CategoryBean findCategoryById(Integer id);

    public List<CategoryBean> listCategory();

    public CategoryBean findCategoryByName(String name);
   
    //SubCategory
    public SubCategoryBean addSubCategory(SubCategoryBean subCategoryBean);

    public SubCategoryBean updateSubCategory(SubCategoryBean subCategoryBean);

    public void removeSubCategory(Integer id);

    public SubCategoryBean findSubCategoryById(Integer id);


    public List<SubCategoryBean> listSubCategory();

    //Size
    public SizeBean addSize(SizeBean sizeBean);

    public SizeBean updateSize(SizeBean sizeBean);

    public void removeSize(Integer id);

    public SizeBean findSizeById(Integer id);

    public List<SizeBean> listSize();

    //Cost
    public CostBean addCost(CostBean costBean);

    public CostBean updateCost(CostBean costBean);

    public void removeCost(Integer id);

    public CostBean findCostById(Integer id);

    public List<CostBean> listCost();

    //Borrow
    public BorrowBean addBorrow(BorrowBean BorrowBean);

    public BorrowBean updateBorrow(BorrowBean borrowBean);

    public void removeBorrow(Integer id);

    public BorrowBean findBorrowById(Integer id);

    public List<BorrowBean> listBorrow();

}

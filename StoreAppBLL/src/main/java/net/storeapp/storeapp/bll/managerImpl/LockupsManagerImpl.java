/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.managerImpl;

import java.util.ArrayList;
import java.util.List;
import net.storeapp.storeapp.bll.manager.LockupsManager;
import net.storeapp.storeapp.bll.trasformer.BorrowTransformer;
import net.storeapp.storeapp.bll.trasformer.CategoryTransformer;
import net.storeapp.storeapp.bll.trasformer.CostTransformer;
import net.storeapp.storeapp.bll.trasformer.CustomerTransformer;
import net.storeapp.storeapp.bll.trasformer.SizeTransformer;
import net.storeapp.storeapp.bll.trasformer.SubCategoryTransformer;
import net.storeapp.storeapp.bll.trasformer.SupplierTransformer;
import net.storeapp.storeapp.bll.trasformer.UserTransformer;
import net.storeapp.storeapp.common.BorrowBean;
import net.storeapp.storeapp.common.CategoryBean;
import net.storeapp.storeapp.common.CostBean;
import net.storeapp.storeapp.common.CustomerBean;
import net.storeapp.storeapp.common.SizeBean;
import net.storeapp.storeapp.common.SubCategoryBean;
import net.storeapp.storeapp.common.SupplierBean;
import net.storeapp.storeapp.common.UserBean;
import net.storeapp.storeapp.dal.entity.BorrowEntity;
import net.storeapp.storeapp.dal.entity.CategoryEntity;
import net.storeapp.storeapp.dal.entity.CostEntity;
import net.storeapp.storeapp.dal.entity.CustomerEntity;
import net.storeapp.storeapp.dal.entity.SizeEntity;
import net.storeapp.storeapp.dal.entity.SubCategoryEntity;
import net.storeapp.storeapp.dal.entity.SupplierEntity;
import net.storeapp.storeapp.dal.entity.UserEntity;
import net.storeapp.storeapp.dal.repo.BorrowRepo;
import net.storeapp.storeapp.dal.repo.CategoryRepo;
import net.storeapp.storeapp.dal.repo.CostRepo;
import net.storeapp.storeapp.dal.repo.CustomerRepo;
import net.storeapp.storeapp.dal.repo.SizeRepo;
import net.storeapp.storeapp.dal.repo.SubCategoryRepo;
import net.storeapp.storeapp.dal.repo.SupplierRepo;
import net.storeapp.storeapp.dal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */
@Transactional
@Service
public class LockupsManagerImpl implements LockupsManager {

    @Autowired
    UserTransformer userTransformer;

    @Autowired
    UserRepo ur;

    @Autowired
    CustomerTransformer customerTransformer;

    @Autowired
    CustomerRepo cr;

    @Autowired
    SupplierTransformer supplierTransformer;

    @Autowired
    SupplierRepo sr;

    @Autowired
    CategoryTransformer categoryTransformer;

    @Autowired
    CategoryRepo catRepo;

    @Autowired
    SubCategoryTransformer subCategoryTransformer;

    @Autowired
    SubCategoryRepo subCatRepo;

    @Autowired
    SizeTransformer sizeTransformer;

    @Autowired
    SizeRepo sizeRepo;

    @Autowired
    BorrowTransformer borrowTransformer;

    @Autowired
    BorrowRepo br;

    @Autowired
    CostTransformer costTransformer;

    @Autowired
    CostRepo costRepo;

    @Override
    public UserBean addUser(UserBean userBean) {
        UserEntity entity = userTransformer.fromBeanToEntity(userBean);
        entity = ur.add(entity);
        userBean = userTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public UserBean updateUser(UserBean userBean) {
        UserEntity entity = userTransformer.fromBeanToEntity(userBean);
        entity = ur.update(entity);
        userBean = userTransformer.fromEntityToBean(entity);
        return userBean;
    }

    @Override
    public void removeUser(Integer id) {
        ur.remove(id);
    }

    @Override
    public UserBean findUserById(Integer id) {
        UserBean bean = userTransformer.fromEntityToBean(ur.findById(id));
        return bean;
    }

    @Override
    public List<UserBean> listUsers() {
        List<UserBean> listUsers = new ArrayList<>();
        List<UserEntity> users = ur.findList();
        for (UserEntity user : users) {
            listUsers.add(userTransformer.fromEntityToBean(user));
        }
        return listUsers;
    }

    @Override
    public CustomerBean addCustomer(CustomerBean customerBean) {
        CustomerEntity entity = customerTransformer.fromBeanToEntity(customerBean);
        cr.add(entity);
        customerBean = customerTransformer.fromEntityToBean(entity);
        return customerBean;
    }

    @Override
    public CustomerBean updateCustomer(CustomerBean customerBean) {
        CustomerEntity entity = customerTransformer.fromBeanToEntity(customerBean);
        cr.update(entity);
        customerBean = customerTransformer.fromEntityToBean(entity);
        return customerBean;
    }

    @Override
    public void removeCustomer(Integer id) {
        cr.remove(id);
    }

    @Override
    public CustomerBean findCustomerById(Integer id) {
        CustomerBean bean = customerTransformer.fromEntityToBean(cr.findById(id));
        return bean;
    }

    @Override
    public List<CustomerBean> listCustomers() {
        List<CustomerBean> listCustomers = new ArrayList<>();
        List<CustomerEntity> customers = cr.findList();
        for (CustomerEntity customer : customers) {
            listCustomers.add(customerTransformer.fromEntityToBean(customer));
        }
        return listCustomers;
    }

    @Override
    public SupplierBean addSupplier(SupplierBean supplierBean) {
        SupplierEntity entity = supplierTransformer.fromBeanToEntity(supplierBean);
        entity = sr.add(entity);
        supplierBean = supplierTransformer.fromEntityToBean(entity);
        return supplierBean;
    }

    @Override
    public SupplierBean updateSupplier(SupplierBean supplierBean) {
        SupplierEntity entity = supplierTransformer.fromBeanToEntity(supplierBean);
        entity = sr.update(entity);
        supplierBean = supplierTransformer.fromEntityToBean(entity);
        return supplierBean;
    }

    @Override
    public void removeSupplier(Integer id) {
        sr.remove(id);
    }

    @Override
    public SupplierBean findSupplierById(Integer id) {
        SupplierBean bean = supplierTransformer.fromEntityToBean(sr.findById(id));
        return bean;
    }

    @Override
    public List<SupplierBean> listSupplier() {
        List<SupplierBean> listCustomers = new ArrayList<>();
        List<SupplierEntity> suppliers = sr.findList();
        for (SupplierEntity supplier : suppliers) {
            listCustomers.add(supplierTransformer.fromEntityToBean(supplier));
        }
        return listCustomers;
    }

    @Override
    public CategoryBean addCategory(CategoryBean categoryBean) {
        CategoryEntity entity = categoryTransformer.fromBeanToEntity(categoryBean);
        entity = catRepo.add(entity);
        categoryBean = categoryTransformer.fromEntityToBean(entity);
        return categoryBean;
    }

    @Override
    public CategoryBean updateCategory(CategoryBean categoryBean) {
        CategoryEntity entity = categoryTransformer.fromBeanToEntity(categoryBean);
        entity = catRepo.update(entity);
        categoryBean = categoryTransformer.fromEntityToBean(entity);
        return categoryBean;
    }

    @Override
    public void removeCategory(Integer id) {
        catRepo.remove(id);
    }

    @Override
    public CategoryBean findCategoryById(Integer id) {
        CategoryBean bean = categoryTransformer.fromEntityToBean(catRepo.findById(id));
        return bean;
    }
    
    @Override
    public CategoryBean findCategoryByName(String name) {
        CategoryBean bean = categoryTransformer.fromEntityToBean(catRepo.findCategoryByName(name));
        return bean;
    }

    @Override
    public List<CategoryBean> listCategory() {
        List<CategoryBean> listCategorys = new ArrayList<>();
        List<CategoryEntity> categorys = catRepo.findList();
        for (CategoryEntity category : categorys) {
            listCategorys.add(categoryTransformer.fromEntityToBean(category));
        }
        return listCategorys;
    }
    
    @Override
    public SubCategoryBean addSubCategory(SubCategoryBean subCategoryBean) {
        SubCategoryEntity entity = subCategoryTransformer.fromBeanToEntity(subCategoryBean);
        entity = subCatRepo.add(entity);
        subCategoryBean = subCategoryTransformer.fromEntityToBean(entity);
        return subCategoryBean;
    }

    @Override
    public SubCategoryBean updateSubCategory(SubCategoryBean subCategoryBean) {
        SubCategoryEntity entity = subCategoryTransformer.fromBeanToEntity(subCategoryBean);
        entity = subCatRepo.update(entity);
        subCategoryBean = subCategoryTransformer.fromEntityToBean(entity);
        return subCategoryBean;
    }

    @Override
    public void removeSubCategory(Integer id) {
        subCatRepo.remove(id);
    }

    @Override
    public SubCategoryBean findSubCategoryById(Integer id) {
        SubCategoryBean bean = subCategoryTransformer.fromEntityToBean(subCatRepo.findById(id));
        return bean;
    }

    @Override
    public List<SubCategoryBean> listSubCategory() {
        List<SubCategoryBean> listCategorys = new ArrayList<>();
        List<SubCategoryEntity> categorys = subCatRepo.findList();
        for (SubCategoryEntity category : categorys) {
            listCategorys.add(subCategoryTransformer.fromEntityToBean(category));
        }
        return listCategorys;
    }

    @Override
    public SizeBean addSize(SizeBean sizeBean) {
        SizeEntity entity = sizeTransformer.fromBeanToEntity(sizeBean);
        entity = sizeRepo.add(entity);
        sizeBean = sizeTransformer.fromEntityToBean(entity);
        return sizeBean;
    }

    @Override
    public SizeBean updateSize(SizeBean sizeBean) {
        SizeEntity entity = sizeTransformer.fromBeanToEntity(sizeBean);
        entity = sizeRepo.update(entity);
        sizeBean = sizeTransformer.fromEntityToBean(entity);
        return sizeBean;
    }

    @Override
    public void removeSize(Integer id) {
        sizeRepo.remove(id);
    }

    @Override
    public SizeBean findSizeById(Integer id) {
        SizeBean bean = sizeTransformer.fromEntityToBean(sizeRepo.findById(id));
        return bean;
    }

    @Override
    public List<SizeBean> listSize() {
        List<SizeBean> listSizes = new ArrayList<>();
        List<SizeEntity> sizes = sizeRepo.findList();
        for (SizeEntity size : sizes) {
            listSizes.add(sizeTransformer.fromEntityToBean(size));
        }
        return listSizes;
    }

    @Override
    public CostBean addCost(CostBean costBean) {
        CostEntity entity = costTransformer.fromBeanToEntity(costBean);
        entity = costRepo.add(entity);
        costBean = costTransformer.fromEntityToBean(entity);
        return costBean;
    }

    @Override
    public CostBean updateCost(CostBean costBean) {
        CostEntity entity = costTransformer.fromBeanToEntity(costBean);
        entity = costRepo.add(entity);
        costBean = costTransformer.fromEntityToBean(entity);
        return costBean;
    }

    @Override
    public void removeCost(Integer id) {
        costRepo.remove(id);
    }

    @Override
    public CostBean findCostById(Integer id) {
        CostBean bean = costTransformer.fromEntityToBean(costRepo.findById(id));
        return bean;
    }

    @Override
    public List<CostBean> listCost() {
        List<CostBean> listCosts = new ArrayList<>();
        List<CostEntity> costs = costRepo.findList();
        for (CostEntity cost : costs) {
            listCosts.add(costTransformer.fromEntityToBean(cost));
        }
        return listCosts;
    }

    @Override
    public BorrowBean addBorrow(BorrowBean borrowBean) {
        BorrowEntity entity = borrowTransformer.fromBeanToEntity(borrowBean);
        entity = br.add(entity);
        borrowBean = borrowTransformer.fromEntityToBean(entity);
        return borrowBean;
    }

    @Override
    public BorrowBean updateBorrow(BorrowBean borrowBean) {
        BorrowEntity entity = borrowTransformer.fromBeanToEntity(borrowBean);
        entity = br.add(entity);
        borrowBean = borrowTransformer.fromEntityToBean(entity);
        return borrowBean;
    }

    @Override
    public void removeBorrow(Integer id) {
        br.remove(id);
    }

    @Override
    public BorrowBean findBorrowById(Integer id) {
        BorrowBean bean = borrowTransformer.fromEntityToBean(br.findById(id));
        return bean;
    }

    @Override
    public List<BorrowBean> listBorrow() {
        List<BorrowBean> listBorrows = new ArrayList<>();
        List<BorrowEntity> borrows = br.findList();
        for (BorrowEntity borrow : borrows) {
            listBorrows.add(borrowTransformer.fromEntityToBean(borrow));
        }
        return listBorrows;
    }

    // <editor-fold defaultstate="collapsed" desc=" GETTERS&SETTERS ">
    public UserTransformer getUserTransformer() {
        return userTransformer;
    }

    public void setUserTransformer(UserTransformer userTransformer) {
        this.userTransformer = userTransformer;
    }

    public CustomerTransformer getCustomerTransformer() {
        return customerTransformer;
    }

    public void setCustomerTransformer(CustomerTransformer customerTransformer) {
        this.customerTransformer = customerTransformer;
    }

    public SupplierTransformer getSupplierTransformer() {
        return supplierTransformer;
    }

    public void setSupplierTransformer(SupplierTransformer supplierTransformer) {
        this.supplierTransformer = supplierTransformer;
    }

    public CategoryTransformer getCategoryTransformer() {
        return categoryTransformer;
    }

    public void setCategoryTransformer(CategoryTransformer categoryTransformer) {
        this.categoryTransformer = categoryTransformer;
    }

    public SizeTransformer getSizeTransformer() {
        return sizeTransformer;
    }

    public void setSizeTransformer(SizeTransformer sizeTransformer) {
        this.sizeTransformer = sizeTransformer;
    }

    public BorrowTransformer getBorrowTransformer() {
        return borrowTransformer;
    }

    public void setBorrowTransformer(BorrowTransformer borrowTransformer) {
        this.borrowTransformer = borrowTransformer;
    }

    public CostTransformer getCostTransformer() {
        return costTransformer;
    }

    public void setCostTransformer(CostTransformer costTransformer) {
        this.costTransformer = costTransformer;
    }

    public UserRepo getUr() {
        return ur;
    }

    public void setUr(UserRepo ur) {
        this.ur = ur;
    }

    public CustomerRepo getCr() {
        return cr;
    }

    public void setCr(CustomerRepo cr) {
        this.cr = cr;
    }

    public SupplierRepo getSr() {
        return sr;
    }

    public void setSr(SupplierRepo sr) {
        this.sr = sr;
    }

    public CategoryRepo getCatRepo() {
        return catRepo;
    }

    public void setCatRepo(CategoryRepo catRepo) {
        this.catRepo = catRepo;
    }

    public SizeRepo getSizeRepo() {
        return sizeRepo;
    }

    public void setSizeRepo(SizeRepo sizeRepo) {
        this.sizeRepo = sizeRepo;
    }

    public BorrowRepo getBr() {
        return br;
    }

    public void setBr(BorrowRepo br) {
        this.br = br;
    }

    public CostRepo getCostRepo() {
        return costRepo;
    }

    public void setCostRepo(CostRepo costRepo) {
        this.costRepo = costRepo;
    }

    // </editor-fold>
}

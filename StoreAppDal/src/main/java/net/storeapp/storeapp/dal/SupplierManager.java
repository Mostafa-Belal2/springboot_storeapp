/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.dal;

import java.util.List;
import net.storeapp.storeapp.dal.entity.CategoryEntity;
import net.storeapp.storeapp.dal.entity.SupplierEntity;
import net.storeapp.storeapp.dal.repo.CategoryRepo;
import net.storeapp.storeapp.dal.repo.SupplierRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierManager {

    @Transactional
    public List<SupplierEntity> findSupplierList(ApplicationContext appCon) {
        SupplierRepo bean = appCon.getBean("supplierRepo", SupplierRepo.class);
        List<SupplierEntity> list = bean.findList();
        return list;
    }

    @Transactional
    public SupplierEntity findCityById(ApplicationContext appCon, Integer id) {
        SupplierRepo bean = appCon.getBean("supplierRepo", SupplierRepo.class);
        List<SupplierEntity> list = bean.findList();
        return bean.findById(id);
    }

    @Transactional
    public CategoryEntity addCategory(ApplicationContext appCon, CategoryEntity categoryEntity) {
        CategoryRepo bean = appCon.getBean("categoryRepo", CategoryRepo.class);
        categoryEntity = bean.add(categoryEntity);
        return categoryEntity;
    }
}

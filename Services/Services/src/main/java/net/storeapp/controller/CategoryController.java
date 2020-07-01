/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.controller;

import java.util.List;
import net.storeapp.storeapp.bll.BllGateway;
import net.storeapp.storeapp.common.CategoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RestController
public class CategoryController {

    final String SUCCESS = "{\"action\": \"Successfully\"}";
    final String Fail = "{\"action\": \"Failed\"}";
    @Autowired
    private BllGateway bllGateway;

    @GetMapping("/getCategory")
    public List<CategoryBean> getCategory() {
        return bllGateway.listCategory();
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@RequestBody CategoryBean bean) {
        try {
            bllGateway.updateCategory(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody CategoryBean bean) {
        try {
//            CategoryBean bean = new CategoryBean(name);
            bllGateway.addCategory(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/getCategoryById")
    public CategoryBean getCategoryById(@RequestParam(value = "id", defaultValue = "0") int id) {
//        return new TestCityBean("Hello", "Hello");
//        System.out.println("ID : " + id);
        return bllGateway.findCategoryById(id);
    }
    
    @PostMapping("/getCategoryByName")
    public CategoryBean getCategoryByName(@RequestParam(value = "name", defaultValue = "0") String name) {
//        return new TestCityBean("Hello", "Hello");
//        System.out.println("ID : " + id);
        return bllGateway.findCategoryByName(name);
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(value = "id", defaultValue = "0") int id) {
        try {
            bllGateway.removeCategory(id);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    public BllGateway getBllGateway() {
        return bllGateway;
    }

    public void setBllGateway(BllGateway bllGateway) {
        this.bllGateway = bllGateway;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.controller;

import java.util.List;
import net.storeapp.storeapp.bll.BllGateway;
import net.storeapp.storeapp.common.CategoryBean;
import net.storeapp.storeapp.common.SubCategoryBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SubCategoryController {

    final String SUCCESS = "{\"action\": \"Successfully\"}";
    final String Fail = "{\"action\": \"Failed\"}";
    @Autowired
    private BllGateway bllGateway;

    @GetMapping("/getSubCategory")
    public List<SubCategoryBean> getSubCategory() {
        return bllGateway.listSubCategory();
    }

    @PostMapping("/updateSubCategory")
    public String updateSubCategory(@RequestBody SubCategoryBean bean) {
        try {
            bllGateway.updateSubCategory(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/addSubCategory")
    public String addSubCategory(@RequestBody SubCategoryBean bean) {
        try {
            bllGateway.addSubCategory(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/getSubCategoryById")
    public SubCategoryBean getSubCategoryById(@RequestParam(value = "id", defaultValue = "0") int id) {
//        return new TestCityBean("Hello", "Hello");
//        System.out.println("ID : " + id);
        return bllGateway.findSubCategoryById(id);
    }

    @PostMapping("/deleteSubCategory")
    public String deleteSubCategory(@RequestParam(value = "id", defaultValue = "0") int id) {
        try {
            bllGateway.removeSubCategory(id);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.controller;

import java.util.List;
import net.storeapp.storeapp.bll.BllGateway;
import net.storeapp.storeapp.common.SupplierBean;
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
public class SupplierController {

    final String SUCCESS = "{\"action\": \"Successfully\"}";
    final String Fail = "{\"action\": \"Failed\"}";
    @Autowired
    private BllGateway bllGateway;

    @GetMapping("/getSupplier")
    public List<SupplierBean> getSupplier() {
        return bllGateway.listSupplier();
    }

    @PostMapping("/updateSupplier")
    public String updateSupplier(@RequestBody SupplierBean bean) {
        try {
            bllGateway.updateSupplier(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/addSupplier")
    public String addSupplier(@RequestBody SupplierBean bean) {
        try {
            bllGateway.addSupplier(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/getSupplierById")
    public SupplierBean getSupplierById(@RequestParam(value = "id", defaultValue = "0") int id) {
//        return new TestCityBean("Hello", "Hello");
//        System.out.println("ID : " + id);
        return bllGateway.findSupplierById(id);
    }

    @PostMapping("/deleteSupplier")
    public String deleteSupplier(@RequestParam(value = "id", defaultValue = "0") int id) {
        try {
            bllGateway.removeSupplier(id);
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

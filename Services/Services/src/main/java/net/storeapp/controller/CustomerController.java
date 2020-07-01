/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.controller;

import java.util.List;
import net.storeapp.storeapp.bll.BllGateway;
import net.storeapp.storeapp.common.CustomerBean;
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
public class CustomerController {

    final String SUCCESS = "{\"action\": \"Successfully\"}";
    final String Fail = "{\"action\": \"Failed\"}";
    @Autowired
    private BllGateway bllGateway;

    @GetMapping("/getCustomer")
    public List<CustomerBean> getCustomer() {
        return bllGateway.listCustomers();
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@RequestBody CustomerBean bean) {
        try {
            bllGateway.updateCustomer(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody CustomerBean bean) {
        try {
            bllGateway.addCustomer(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/getCustomerById")
    public CustomerBean getCustomerById(@RequestParam(value = "id", defaultValue = "0") int id) {
//        return new TestCityBean("Hello", "Hello");
//        System.out.println("ID : " + id);
        return bllGateway.findCustomerById(id);
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam(value = "id", defaultValue = "0") int id) {
        try {
            bllGateway.removeCustomer(id);
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

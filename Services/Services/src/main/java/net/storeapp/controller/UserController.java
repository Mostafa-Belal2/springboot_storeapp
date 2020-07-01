/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.controller;

import java.util.List;
import net.storeapp.storeapp.bll.BllGateway;
import net.storeapp.storeapp.common.UserBean;
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
public class UserController {

    final String SUCCESS = "{\"action\": \"Successfully\"}";
    final String Fail = "{\"action\": \"Failed\"}";
    @Autowired
    private BllGateway bllGateway;

    @GetMapping("/getUser")
    public List<UserBean> getUser() {
        return bllGateway.listUsers();
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody UserBean bean) {
        try {
            bllGateway.updateUser(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserBean bean) {
        try {
            bllGateway.addUser(bean);
            return SUCCESS;
        } catch (Exception e) {
            return Fail;
        }
    }

    @PostMapping("/getUserById")
    public UserBean getUserById(@RequestParam(value = "id", defaultValue = "0") int id) {
//        return new TestCityBean("Hello", "Hello");
//        System.out.println("ID : " + id);
        return bllGateway.findUserById(id);
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id", defaultValue = "0") int id) {
        try {
            bllGateway.removeUser(id);
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

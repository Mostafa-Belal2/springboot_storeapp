/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.common;

/**
 *
 * @author dell
 */
public class CustomerBean {

    private Integer id;
    private String name;

    public CustomerBean() {
    }

    public CustomerBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerBean(String name) {
        this.name = name;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

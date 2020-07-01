/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.common;

import java.util.Date;

/**
 *
 * @author dell
 */
public class BorrowBean {

    private Integer id;
    private String name;
    private String details;
    private long price;
    private Date date;
    private Date time;

    public BorrowBean() {
    }

    public BorrowBean(Integer id, String name, String details, long price, Date date, Date time) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.date = date;
        this.time = time;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}

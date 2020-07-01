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
public class DamageBean {

    private Integer id;
    private CategoryBean category;
    private SizeBean size;
    private String name;
    private long price;
    private long quantity;
    private Date date;
    private Date time;

    public DamageBean() {
    }

    public DamageBean(Integer id, CategoryBean category, SizeBean size, String name, long price, long quantity, Date date, Date time) {
        this.id = id;
        this.category = category;
        this.size = size;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public SizeBean getSize() {
        return size;
    }

    public void setSize(SizeBean size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
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

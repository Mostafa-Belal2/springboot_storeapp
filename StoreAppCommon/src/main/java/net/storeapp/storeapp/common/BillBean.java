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
public class BillBean {

    private Integer id;
    private String type;
    private String details;
    private long totalCost;
    private long pay;
    private long reminder;
    private Date startDate;
    private Date endDate;
    private Date time;

    public BillBean() {
    }

    
    public BillBean(Integer id, String type, String details, long totalCost, long pay, long reminder, Date startDate, Date endDate, Date time) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.totalCost = totalCost;
        this.pay = pay;
        this.reminder = reminder;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
        this.pay = pay;
    }

    public long getReminder() {
        return reminder;
    }

    public void setReminder(long reminder) {
        this.reminder = reminder;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}

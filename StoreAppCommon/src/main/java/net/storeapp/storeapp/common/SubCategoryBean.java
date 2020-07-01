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
public class SubCategoryBean {

    private Integer id;
    private String name;
    private CategoryBean categoryBean;

    public SubCategoryBean() {
    }

    
    public SubCategoryBean(Integer id, String name, CategoryBean categoryBean) {
        this.id = id;
        this.name = name;
        this.categoryBean = categoryBean;
    }

    public SubCategoryBean(String name, CategoryBean categoryBean) {
        this.name = name;
        this.categoryBean = categoryBean;
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

    public CategoryBean getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(CategoryBean categoryBean) {
        this.categoryBean = categoryBean;
    }
    
}

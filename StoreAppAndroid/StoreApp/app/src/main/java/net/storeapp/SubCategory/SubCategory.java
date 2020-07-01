package net.storeapp.SubCategory;

import com.google.gson.annotations.SerializedName;

import net.storeapp.Category.Category;

public class SubCategory {

    private Integer id;

    private String name;

    private Category categoryBean;

    private String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Category getCategory() {
        return categoryBean;
    }

    public void setCategory(Category categoryBean) {
        this.categoryBean = categoryBean;
    }

    public SubCategory(int id, String name, Category categoryBean) {
        this.id = id;
        this.name = name;
        this.categoryBean=categoryBean;
    }

    public SubCategory(String name,Category categoryBean) {
        this.name = name;
        this.categoryBean=categoryBean;
    }
}

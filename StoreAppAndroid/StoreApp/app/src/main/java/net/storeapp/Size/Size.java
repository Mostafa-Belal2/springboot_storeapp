package net.storeapp.Size;

import com.google.gson.annotations.SerializedName;

public class Size {

    private Integer id;
    private String name;
    private String action;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public Size(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Size(String name) {
        this.name = name;
    }

}

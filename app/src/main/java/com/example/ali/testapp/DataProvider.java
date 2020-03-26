package com.example.ali.testapp;

public class DataProvider {
    private String tag, category, user;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public DataProvider(String tag, String category, String user){
        this.tag = tag;
        this.category = category;
        this.user = user;

    }

}

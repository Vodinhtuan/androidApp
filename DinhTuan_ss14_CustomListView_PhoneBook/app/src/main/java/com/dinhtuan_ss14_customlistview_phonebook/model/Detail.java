package com.dinhtuan_ss14_customlistview_phonebook.model;

public class Detail {
    private String name;
    private String phone;

    public Detail() {
    }

    public Detail(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

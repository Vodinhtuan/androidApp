package com.dinhtuan_ss14_customlistview_phonebook.model;

public class PhoneBook {
    private String name;
    private int phoneNumber;
    private int callImg;
    private int smsImg;
    private int detailImg;

    public PhoneBook() {
    }

    public PhoneBook(String name, int phoneNumber, int callImg, int smsImg, int detailImg) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.callImg = callImg;
        this.smsImg = smsImg;
        this.detailImg = detailImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCallImg() {
        return callImg;
    }

    public void setCallImg(int callImg) {
        this.callImg = callImg;
    }

    public int getSmsImg() {
        return smsImg;
    }

    public void setSmsImg(int smsImg) {
        this.smsImg = smsImg;
    }

    public int getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(int detailImg) {
        this.detailImg = detailImg;
    }
}

package com.nixsolutions.dto;

import java.util.Date;

public class GoodsRequestDto {

    private String nameOfGood;
    private int count;
    private double price;
    private String storageID;
    private Date startDateOfStorage;

    public String getNameOfGood() {
        return nameOfGood;
    }

    public void setNameOfGood(String nameOfGood) {
        this.nameOfGood = nameOfGood;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStorageID() {
        return storageID;
    }

    public void setStorageID(String storageID) {
        this.storageID = storageID;
    }

    public Date getStartDateOfStorage() {
        return startDateOfStorage;
    }

    public void setStartDateOfStorage(Date startDateOfStorage) {
        this.startDateOfStorage = startDateOfStorage;
    }

}

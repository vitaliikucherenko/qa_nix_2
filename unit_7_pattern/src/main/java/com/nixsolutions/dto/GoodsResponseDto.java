package com.nixsolutions.dto;

import com.nixsolutions.entity.Goods;

import java.util.Date;

public class GoodsResponseDto {

    private String id;
    private String nameOfGood;
    private int count;
    private double price;
    private String storageID;
    private Date startDateOfStorage;
    private double sum;

    public GoodsResponseDto(Goods goods) {
        this.id = goods.getId();
        this.nameOfGood = goods.getNameOfGood();
        this.count = goods.getCount();
        this.price = goods.getPrice();
        this.storageID = goods.getStorageID();
        this.startDateOfStorage = goods.getStartDateOfStorage();
        this.sum = generateSum(goods);
    }

    private double generateSum(final Goods goods) {
        double totalSum = count * price;
        return totalSum;
    }

    public String getId() {
        return id;
    }

    public String getNameOfGood() {
        return nameOfGood;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public String getStorageID() {
        return storageID;
    }

    public Date getStartDateOfStorage() {
        return startDateOfStorage;
    }

    public double getSum() {
        return sum;
    }
}

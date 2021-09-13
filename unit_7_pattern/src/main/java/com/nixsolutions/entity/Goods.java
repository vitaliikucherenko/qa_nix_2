package com.nixsolutions.entity;

import java.util.Date;

public class Goods {

    private String id;
    private String nameOfGood;
    private int count;
    private double price;
    private String storageID;
    private Date startDateOfStorage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public static Builder newGoods() {
        return new Goods().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(String id) {
            Goods.this.id = id;
            return this;
        }

        public Builder setNameOfGood(String nameOfGood) {
            Goods.this.nameOfGood = nameOfGood;
            return this;
        }

        public Builder setCount(int count) {
            Goods.this.count = count;
            return this;
        }

        public Builder setPrice(double price) {
            Goods.this.price = price;
            return this;
        }

        public Builder setStorageID(String storageID) {
            Goods.this.storageID = storageID;
            return this;
        }

        public Builder setStartDateOfStorage(Date startDateOfStorage) {
            Goods.this.startDateOfStorage = startDateOfStorage;
            return this;
        }

        public Goods build() {
            return Goods.this;
        }
    }
}

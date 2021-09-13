package com.nixsolutions.entity;

import java.util.Date;

public class Storage {

    private String id;
    private String nameOfStorage;
    private String goodID;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodID() {
        return goodID;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public String getNameOfStorage() {
        return nameOfStorage;
    }

    public void setNameOfStorage(String nameOfStorage) {
        this.nameOfStorage = nameOfStorage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Storage.Builder newStorage() {
        return new Storage().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Storage.Builder setId(String id) {
            Storage.this.id = id;
            return this;
        }

        public Storage.Builder setNameOfStorage(String nameOfStorage) {
            Storage.this.nameOfStorage = nameOfStorage;
            return this;
        }

        public Storage.Builder setGoodID(String goodID) {
            Storage.this.goodID = goodID;
            return this;
        }

        public Storage.Builder setDescription(String description) {
            Storage.this.description = description;
            return this;
        }

        public Storage build() {
            return Storage.this;
        }
    }
}

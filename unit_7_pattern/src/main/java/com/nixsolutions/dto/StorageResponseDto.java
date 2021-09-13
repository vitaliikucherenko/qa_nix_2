package com.nixsolutions.dto;

import com.nixsolutions.entity.Storage;

public class StorageResponseDto {

    private String id;
    private String nameOfStorage;
    private String goodID;
    private String description;

    public StorageResponseDto(Storage storage) {
        this.id = storage.getId();
        this.nameOfStorage = storage.getNameOfStorage();
        this.goodID = storage.getGoodID();
        this.description = storage.getDescription();
    }

    public String getId() {
        return id;
    }

    public String getNameOfStorage() {
        return nameOfStorage;
    }

    public String getGoodID() {
        return goodID;
    }

    public String getDescription() {
        return description;
    }
}

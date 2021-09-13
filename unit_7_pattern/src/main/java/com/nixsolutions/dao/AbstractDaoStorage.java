package com.nixsolutions.dao;

import com.nixsolutions.entity.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDaoStorage {

    protected List<Storage> storages = new ArrayList<>();

    protected void createStorage(Storage storage) {
        storage.setId(generateId());
        storages.add(storage);
    }

    protected void updateStorage(Storage storage) {
        if (existById(storage.getId())) {
            Storage current = findStorageById(storage.getId());
            current.setId(storage.getId());
            current.setNameOfStorage(storage.getNameOfStorage());
            current.setGoodID(storage.getGoodID());
            current.setDescription(storage.getDescription());
        }
    }

    protected void deleteDelete(String id) {
        storages.removeIf(storage -> storage.getId().equals(id));
    }

    protected Storage findStorageById(String id) {
        return storages.stream().filter(storage -> storage.getId().equals(id)).findFirst().get();
    }

    protected Storage findStorageByName(String nameOfStorage) {
        return storages.stream().filter(storage -> storage.getNameOfStorage().equals(nameOfStorage)).findFirst().get();
    }

    protected List<Storage> findAllStorage() {
        return storages;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return storages.stream().anyMatch(storage -> storage.getId().equals(id));
    }

}

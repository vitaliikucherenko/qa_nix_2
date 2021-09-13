package com.nixsolutions.service;

import com.nixsolutions.entity.Storage;

import java.util.List;

public interface StorageService {

    void create(Storage storage);

    void update(Storage storage);

    void delete(String id);

    Storage findById(String id);

    List<Storage> findAll();
}

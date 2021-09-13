package com.nixsolutions.dao;

import com.nixsolutions.entity.Storage;

import java.util.List;

public interface StorageDao {

    void create (Storage storage);
    void update (Storage storage);
    void delete (String id);
    Storage findById (String id);
    List<Storage> findAll();
 }

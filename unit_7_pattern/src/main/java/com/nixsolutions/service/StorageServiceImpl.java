package com.nixsolutions.service;

import com.nixsolutions.config.DaoFactory;
import com.nixsolutions.dao.GoodsDao;
import com.nixsolutions.dao.StorageDao;
import com.nixsolutions.entity.Goods;
import com.nixsolutions.entity.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageDao storageDao = DaoFactory.getInstance().getStorageDao();

    @Override
    public void create(Storage storage) {
        storageDao.create(storage);

    }

    @Override
    public void update(Storage storage) {
        storageDao.update(storage);
    }

    @Override
    public void delete(String id) {
        storageDao.delete(id);
    }

    @Override
    public Storage findById(String id) {
        return storageDao.findById(id);
    }

    @Override
    public List<Storage> findAll() {
        return storageDao.findAll();
    }
}

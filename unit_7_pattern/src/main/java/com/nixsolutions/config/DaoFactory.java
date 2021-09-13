package com.nixsolutions.config;

import com.nixsolutions.dao.*;
import com.nixsolutions.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;
    private GoodsDao goodsDao;
    private StorageDao storageDao;
    private DaoType daoType;

    private DaoFactory() { }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public GoodsDao getGoodsDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (goodsDao == null) {
                    goodsDao = new CsvGoodsDao();
                }
            } break;
            case JSON : {
                if (goodsDao == null) {
                    goodsDao = new JsonGoodsDao();
                }
            } break;
        }
        return goodsDao;
    }

    public StorageDao getStorageDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (storageDao == null) {
                    storageDao = new CsvStorageDao();
                }
            } break;
            case JSON : {
                if (storageDao == null) {
                    storageDao = new JsonStorageDao();
                }
            } break;
        }
        return storageDao;
    }
}

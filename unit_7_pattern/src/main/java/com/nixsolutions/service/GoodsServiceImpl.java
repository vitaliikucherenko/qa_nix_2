package com.nixsolutions.service;

import com.nixsolutions.config.DaoFactory;
import com.nixsolutions.dao.GoodsDao;
import com.nixsolutions.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    private final GoodsDao goodsDao = DaoFactory.getInstance().getGoodsDao();

    @Override
    public void create(Goods goods) {
        goodsDao.create(goods);
    }

    @Override
    public void update(Goods goods) {
        goodsDao.update(goods);
    }

    @Override
    public void delete(String id) {
        goodsDao.delete(id);
    }

    @Override
    public Goods findById(String id) {
        return goodsDao.findById(id);
    }

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }
}

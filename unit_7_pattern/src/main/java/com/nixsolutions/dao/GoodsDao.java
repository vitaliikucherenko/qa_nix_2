package com.nixsolutions.dao;

import com.nixsolutions.entity.Goods;

import java.util.List;

public interface GoodsDao {

    void create (Goods goods);
    void update (Goods goods);
    void delete (String id);
    Goods findById (String id);
    List<Goods> findAll();
 }

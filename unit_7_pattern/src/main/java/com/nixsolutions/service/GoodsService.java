package com.nixsolutions.service;

import com.nixsolutions.entity.Goods;

import java.util.List;

public interface GoodsService {

    void create (Goods goods);
    void update (Goods goods);
    void delete (String id);
    Goods findById (String id);
    List<Goods> findAll();
}

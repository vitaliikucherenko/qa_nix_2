package com.nixsolutions.dao;

import com.nixsolutions.entity.Goods;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoGoods {

    protected List<Goods> goods = new ArrayList<>();

    protected void createGoods(Goods good) {
        good.setId(generateId());
        goods.add(good);
    }

    protected void updateGoods(Goods goods) {
        if (existById(goods.getId())) {
            Goods current = findGoodsById(goods.getId());
            current.setId(goods.getId());
            current.setNameOfGood(goods.getNameOfGood());
            current.setCount(goods.getCount());
            current.setPrice(goods.getPrice());
            current.setStorageID(goods.getStorageID());
            current.setStartDateOfStorage(goods.getStartDateOfStorage());
        }
    }

    protected void deleteDelete(String id) {
        goods.removeIf(goods -> goods.getId().equals(id));
    }

    protected Goods findGoodsById(String id) {
        return goods.stream().filter(goods -> goods.getId().equals(id)).findFirst().get();
    }

    protected Goods findGoodByName(String nameOfGood) {
        return goods.stream().filter(goods -> goods.getNameOfGood().equals(nameOfGood)).findFirst().get();
    }

    protected List<Goods> findAllGoods() {
        return goods;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return goods.stream().anyMatch(goods -> goods.getId().equals(id));
    }

}

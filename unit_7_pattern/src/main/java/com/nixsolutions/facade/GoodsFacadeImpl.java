package com.nixsolutions.facade;

import com.nixsolutions.dto.GoodsRequestDto;
import com.nixsolutions.dto.GoodsResponseDto;
import com.nixsolutions.entity.Goods;
import com.nixsolutions.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsFacadeImpl implements GoodsFacade {

    private final GoodsService goodsService;

    public GoodsFacadeImpl(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void create(GoodsRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(GoodsRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        goodsService.delete(id);
    }

    @Override
    public GoodsResponseDto findById(String id) {
        return new GoodsResponseDto(goodsService.findById(id));
    }

    @Override
    public List<GoodsResponseDto> findAll() {
        return goodsService.findAll().stream().map(GoodsResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(GoodsRequestDto dto, String id) {
        Goods good = new Goods();
        good.setNameOfGood(dto.getNameOfGood());
        good.setCount(dto.getCount());
        good.setPrice(dto.getPrice());
        good.setStorageID(dto.getStorageID());
        good.setStartDateOfStorage(dto.getStartDateOfStorage());
            if (id == null) {
            goodsService.create(good);
        } else {
            good.setId(id);
            goodsService.update(good);
        }
    }
}

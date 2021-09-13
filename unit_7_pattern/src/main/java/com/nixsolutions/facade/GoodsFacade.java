package com.nixsolutions.facade;

import com.nixsolutions.dto.GoodsRequestDto;
import com.nixsolutions.dto.GoodsResponseDto;

import java.util.List;

public interface GoodsFacade {
    void create (GoodsRequestDto dto);
    void update(GoodsRequestDto dto, String id);
    void delete(String id);
    GoodsResponseDto findById(String id);
    List<GoodsResponseDto> findAll();
}

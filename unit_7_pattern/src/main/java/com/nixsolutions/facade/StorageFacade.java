package com.nixsolutions.facade;


import com.nixsolutions.dto.StorageRequestDto;
import com.nixsolutions.dto.StorageResponseDto;

import java.util.List;

public interface StorageFacade {

    void create(StorageRequestDto dto);
    void update(StorageRequestDto dto, String id);
    void delete(String id);
    StorageResponseDto findById(String id);
    List<StorageResponseDto> findAll();
}

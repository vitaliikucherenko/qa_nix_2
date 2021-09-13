package com.nixsolutions.facade;

import com.nixsolutions.dto.StorageRequestDto;
import com.nixsolutions.dto.StorageResponseDto;
import com.nixsolutions.entity.Storage;
import com.nixsolutions.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageFacadeImpl implements StorageFacade {

    private final StorageService storageService;

    public StorageFacadeImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void create(StorageRequestDto dto) {
        createOrUpdate(dto,null);
    }

    @Override
    public void update(StorageRequestDto dto, String id) {
        createOrUpdate(dto,id);
    }

    @Override
    public void delete(String id) {
        storageService.delete(id);
    }

    @Override
    public StorageResponseDto findById(String id) {
        return new StorageResponseDto(storageService.findById(id));
    }

    @Override
    public List<StorageResponseDto> findAll() {
        return storageService.findAll().stream().map(StorageResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(StorageRequestDto dto, String id) {
        Storage storage = new Storage();
        storage.setNameOfStorage(dto.getNameOfStorage());
        storage.setGoodID(dto.getGoodID());
        storage.setDescription(dto.getDescription());
        if (id == null) {
            storageService.create(storage);
        } else {
            storage.setId(id);
            storageService.update(storage);
        }
    }
}

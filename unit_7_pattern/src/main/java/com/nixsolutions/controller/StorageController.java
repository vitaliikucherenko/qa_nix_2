package com.nixsolutions.controller;

import com.nixsolutions.dto.ResponseContainer;
import com.nixsolutions.dto.StorageRequestDto;
import com.nixsolutions.dto.StorageResponseDto;
import com.nixsolutions.facade.StorageFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/storage")
public class StorageController {

    private final StorageFacade storageFacade;

    public StorageController(StorageFacade storageFacade) {
        this.storageFacade = storageFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody StorageRequestDto dto) {
        storageFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody StorageRequestDto dto, @PathVariable String id) {
        storageFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        storageFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<StorageResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(storageFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<StorageResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(storageFacade.findAll()));
    }
}

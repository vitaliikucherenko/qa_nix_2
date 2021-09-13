package com.nixsolutions.controller;

import com.nixsolutions.dto.GoodsRequestDto;
import com.nixsolutions.dto.GoodsResponseDto;
import com.nixsolutions.dto.ResponseContainer;
import com.nixsolutions.facade.GoodsFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    private final GoodsFacade goodsFacade;

    public GoodsController(GoodsFacade goodsFacade) {
        this.goodsFacade = goodsFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody GoodsRequestDto dto) {
        goodsFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody GoodsRequestDto dto, @PathVariable String id) {
        goodsFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        goodsFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<GoodsResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(goodsFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<GoodsResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(goodsFacade.findAll()));
    }
}

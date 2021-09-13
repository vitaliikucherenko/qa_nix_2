package com.nixsolutions.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.nixsolutions.config.FileType;
import com.nixsolutions.entity.Goods;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonGoodsDao")
public class JsonGoodsDao extends AbstractDaoGoods implements GoodsDao, FileInterface {


    @Override
    public void load() {
        super.goods.clear();
        try {
            String goodsOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.goods = objectMapper.readValue(goodsOut, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store() {
        Gson gson = new GsonBuilder()
           .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
            .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String goodsOut = gson.toJson(goods);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(goodsOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Goods goods) {
        load();
        createGoods(goods);
        store();
    }

    @Override
    public void update(Goods goods) {
        load();
        updateGoods(goods);
        store();
    }

    @Override
    public void delete(String id) {
        load();
        deleteDelete(id);
        store();
    }

    @Override
    public Goods findById(String id) {
        load();
        return findGoodsById(id);
    }

    @Override
    public List<Goods> findAll() {
        load();
        return findAllGoods();
    }

}

package com.nixsolutions.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.nixsolutions.config.FileType;
import com.nixsolutions.entity.Goods;
import com.nixsolutions.entity.Storage;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonStorageDao")
public class JsonStorageDao extends AbstractDaoStorage implements StorageDao, FileInterface {
    @Override
    public void create(Storage storage) {
        load();
        createStorage(storage);
        store();
    }

    @Override
    public void update(Storage storage) {
        load();
        updateStorage(storage);
        store();
    }

    @Override
    public void delete(String id) {
        load();
        deleteDelete(id);
        store();
    }

    @Override
    public Storage findById(String id) {
        load();
        return findStorageById(id);
    }

    @Override
    public List<Storage> findAll() {
        load();
        return findAllStorage();
    }

    @Override
    public void load() {
        super.storages.clear();
        try {
            String storageOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE_S.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.storages = objectMapper.readValue(storageOut, new TypeReference<>() {
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
        String storageOut = gson.toJson(storages);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE_S.getPath()))) {
            writer.append(storageOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.nixsolutions.dao;
import com.nixsolutions.config.FileType;
import com.nixsolutions.entity.Goods;
import com.nixsolutions.entity.Storage;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("CsvStorageDao")
public class CsvStorageDao extends AbstractDaoStorage implements StorageDao, FileInterface{

    private final List<String[]> csvData = new ArrayList<>();

    @Override
    public void load() {
        try (CSVReader reader = new CSVReader(new FileReader(FileType.CSV_TYPE_S.getPath()))) {
            super.storages.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Storage storage = Storage.newStorage()
                            .setId(re[0])
                            .setNameOfStorage(re[1])
                            .setGoodID(re[2])
                            .setDescription(re[3])
                            .build();
                    super.storages.add(storage);
                } catch (Exception e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store() {
        this.csvData.clear();
        writeHeader();
        for (Storage u : super.storages) {
            String[] currentStorage = new String[4];
            currentStorage[0] = u.getId();
            currentStorage[1] = u.getNameOfStorage();
            currentStorage[2] = u.getGoodID();
            currentStorage[3] = u.getDescription();
            csvData.add(currentStorage);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(FileType.CSV_TYPE_S.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = {"id", "Name Of Storage", "GoodID", "Description"};
        csvData.add(header);
    }

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

}

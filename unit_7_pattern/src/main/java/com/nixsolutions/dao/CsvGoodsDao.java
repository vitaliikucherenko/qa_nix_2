package com.nixsolutions.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.nixsolutions.config.FileType;
import com.nixsolutions.entity.Goods;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CsvGoodsDao")
public class CsvGoodsDao extends AbstractDaoGoods implements GoodsDao, FileInterface {

    private final List<String[]> csvData = new ArrayList<>();

    @Override
    public void load() {
        try (CSVReader reader = new CSVReader(new FileReader(FileType.CSV_TYPE.getPath()))) {
            super.goods.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Goods goods = Goods.newGoods()
                            .setId(re[0])
                            .setNameOfGood(re[1])
                            .setCount(Integer.valueOf(re[2]))
                            .setPrice(Double.valueOf(re[3]))
                            .setStorageID(re[4])
                            .setStartDateOfStorage(new Date(Long.parseLong(re[5])))
                            .build();
                    super.goods.add(goods);
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
        for (Goods u : super.goods) {
            String[] currentGood = new String[6];
            currentGood[0] = u.getId();
            currentGood[1] = u.getNameOfGood();
            currentGood[2] = String.valueOf(u.getCount());
            currentGood[3] = String.valueOf(u.getPrice());
            currentGood[4] = u.getStorageID();
            currentGood[5] = String.valueOf(u.getStartDateOfStorage().getTime());
            csvData.add(currentGood);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(FileType.CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = {"id", "Name Of Good", "Count", "Price", "StorageID", "StartDateOfStorage"};
        csvData.add(header);
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

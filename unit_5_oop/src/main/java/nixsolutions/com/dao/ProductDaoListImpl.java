package nixsolutions.com.dao;

import nixsolutions.com.db.ProductDB;
import nixsolutions.com.entity.Product;
import java.util.List;

public class ProductDaoListImpl implements ProductDao{
    private ProductDB db = new ProductDB();

    public ProductDaoListImpl() {
        System.out.println("ProductDaoListImpl.ProductDaoListImpl");
    }

    public void create(Product productA) {
        db.create(productA);
    }

    public void update(Product productA) {
        db.update(productA);
    }

    public void delete(String id) {
        db.delete(id);
    }

    public Product findById(String id) {
        return db.findById(id);
    }

    public Product[] findAll() {
        return db.findAll();
    }
}
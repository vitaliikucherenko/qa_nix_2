package nixsolutions.com.service;

import nixsolutions.com.dao.ProductDao;
import nixsolutions.com.dao.ProductDaoListImpl;
import nixsolutions.com.entity.Product;
import java.util.List;

public class ProductService {
    private ProductDao dao = new ProductDaoListImpl();

    public void create(Product productA) {
        dao.create(productA);
    }

    public void update(Product productA) {
        dao.update(productA);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public Product findById(String id) {
        return dao.findById(id);
    }

    public Product[] findAll() {
        return dao.findAll();
    }
}
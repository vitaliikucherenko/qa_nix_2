package nixsolutions.com.dao;

import nixsolutions.com.entity.Product;
import java.util.List;

public interface ProductDao {
        void create(Product productA);
        void update(Product productA);
        void delete(String id);
        Product findById(String id);
        Product[] findAll();
}
package nixsolutions.com.db;

import nixsolutions.com.entity.Product;

import java.util.UUID;

public class ProductDB {
    private int capacity = 2;
    private Product[] productStorage = new Product[capacity];
    private int internalCounter = 0;

    public void create(Product productA) {
        if (internalCounter >= capacity) {
            capacity += capacity + 1;
            Product[] newStorage = new Product[capacity];
            for (int i = 0; i < productStorage.length; i++) {
                newStorage[i] = productStorage[i];
            }
            productStorage = newStorage;
        }
        productA.setId(generateId());
        productStorage[internalCounter] = productA;
        internalCounter++;
    }

    public void update(Product productA) {
        Product currentProduct = findById(productA.getId());
        if (currentProduct != null) {
            currentProduct.setName(productA.getName());
            currentProduct.setDescription(productA.getDescription());
            currentProduct.setCount(productA.getCount());
            currentProduct.setPrice(productA.getPrice());
        }
    }

    public void delete(String id) {
        int index = -1;
        for (int i = 0; i < productStorage.length; i++) {
            if (productStorage[i] != null && productStorage[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            for (int j = index; j < productStorage.length - 1; j++) {
                productStorage[j] = productStorage[j + 1];
            }
            productStorage[productStorage.length - 1] = null;
            internalCounter--;
        }
//remove null element and change massive size
        int count = 0;
        for (int k = 0; k < productStorage.length; k++) {
            if (productStorage[k] == null) {
                count++;
            }
        }
        capacity = productStorage.length - count;
        Product[] newStorage = new Product[capacity];
        for (int i = 0; i < capacity; i++) {
            newStorage[i] = productStorage[i];
        }
        productStorage = newStorage;
    }

    public Product findById(String id) {
        for (int i = 0; i < productStorage.length; i++) {
            if (productStorage[i] != null && productStorage[i].getId().equals(id)) {
                return productStorage[i];
            }
        }
        return null;
    }

    public Product[] findAll() {
        return productStorage;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        Product p = findById(id);
        if (p != null) {
            return generateId();
        }
        return id;
    }
}
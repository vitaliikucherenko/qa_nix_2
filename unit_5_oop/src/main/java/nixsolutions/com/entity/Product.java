package nixsolutions.com.entity;

public class Product extends BaseEntity {
    private String name;
    private String description;
    private int count;
    private double price;

    @Override
    public String toString() {
        return "(id = '" + super.getId() + '\'' +
                ", Product name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", count = '" + count +'\'' +
                ", price = '" + price +'\'' +
                ')';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
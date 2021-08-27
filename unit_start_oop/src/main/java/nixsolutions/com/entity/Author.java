package nixsolutions.com.entity;

import java.util.ArrayList;
import java.util.List;

public class Author extends BaseEntity {

    private String name;
    private List<String> bookIds = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +'\'' +
                ", name='" + name + '\'' +
                ", bookIds=" + bookIds +
                '}';
    }
}

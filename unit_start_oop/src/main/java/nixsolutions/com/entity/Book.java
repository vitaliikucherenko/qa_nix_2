package nixsolutions.com.entity;

import nixsolutions.com.entity.style.BookStyle;
import java.util.Date;

public class Book extends BaseEntity{

    private BookStyle bookStyle;
    private String authorId;

    public Book() {}

    public Book(BookStyle bookStyle) {
        this.bookStyle = bookStyle;
        super.setStartDate(new Date());
    }

    public BookStyle getBookStyle() {
        return bookStyle;
    }

    public void setBookStyle(BookStyle bookStyle) {
        this.bookStyle = bookStyle;
    }

    public String getReaderId() {
        return authorId;
    }

    public void setReaderId(String readerId) {
        this.authorId = readerId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +'\'' +
                ", bookStyle=" + bookStyle +'\'' +
                ", readerId='" + authorId + '\'' +
                '}';
    }
}

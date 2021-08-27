package nixsolutions.com.db;

import nixsolutions.com.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookDB {

    private List<Book> books = new ArrayList<>();
    private static final BookDB instance = new BookDB();

    private BookDB() {
    }

    public static BookDB getInstance() {
        return instance;
    }

    public void create(Book book) {
        book.setId(generateId());
        books.add(book);
    }

    public void update(Book book) {
        Book current = books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().get();
    }

    public void delete(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public void linkAuthor(String authorId, String bookId) {
        Book current = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().get();
        current.setId(authorId);
    }

    public void unlinkAuthor(String bookId) {
        Book current = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().get();
        current.setId(null);
    }

    public Book findById(String id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().get();
    }

    public List<Book> findAll() {
        return books;
    }

    public List<Book> findAllByBooks(String bookId) {
        return books.stream()
                .filter(book -> book.getId() != null)
                .filter(book -> book.getId().equals(bookId)).collect(Collectors.toList());
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (books.stream().anyMatch(book -> book.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}

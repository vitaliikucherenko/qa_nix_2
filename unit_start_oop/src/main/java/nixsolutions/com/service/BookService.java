package nixsolutions.com.service;

import nixsolutions.com.db.BookDB;
import nixsolutions.com.entity.Book;

import java.util.List;

public class BookService implements CrudService<Book>{

    private BookDB bookDB = BookDB.getInstance();

    @Override
    public void create(Book book) {
        bookDB.create(book);
    }

    @Override
    public void update(Book book) {
        bookDB.update(book);
    }

    @Override
    public void delete(String id) {
        bookDB.delete(id);
    }

    @Override
    public Book findById(String id) {
        return bookDB.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDB.findAll();
    }
}

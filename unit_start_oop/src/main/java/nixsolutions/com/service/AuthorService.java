package nixsolutions.com.service;

import nixsolutions.com.db.AuthorDB;
import nixsolutions.com.db.BookDB;
import nixsolutions.com.entity.Author;
import java.util.List;

public class AuthorService implements CrudService<Author> {

    private AuthorDB authorDB = new AuthorDB();
    private BookDB bookDB = BookDB.getInstance();


    @Override
    public void create(Author author) {
        authorDB.create(author);
    }

    public void linkBook(String authorId, String bookId){
        if(!authorDB.existBook(authorId,bookId)){
            authorDB.linkBook(authorId,bookId);
            bookDB.linkAuthor(authorId,bookId);
        }
    }

    @Override
    public void update(Author author) {
        authorDB.update(author);
    }

    @Override
    public void delete(String id) {
        Author author = findById(id);
        for (String bookId : author.getBookIds()) {
            bookDB.unlinkAuthor(bookId);
        }
        authorDB.delete(id);
    }

    @Override
    public Author findById(String id) {
        return authorDB.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDB.findAll();
    }
}

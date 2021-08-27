package nixsolutions.com.db;

import nixsolutions.com.entity.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorDB {

    private List<Author> authors = new ArrayList<>();

    public void create(Author author) {
        author.setId(generateId());
        authors.add(author);
    }

    public void update(Author author) {
        Author current = authors.stream().filter(a -> a.getId().equals(author)).findFirst().get();
        current.setName(author.getName());
    }

    public boolean existBook(String authorId, String bookId) {
        Author current = authors.stream().filter(a -> a.getId().equals(authorId)).findFirst().get();
        return current.getBookIds().stream().anyMatch(id -> id.equals(bookId));
    }

    public void linkBook(String authorId, String bookId) {
        Author current = authors.stream().filter(a -> a.getId().equals(authorId)).findFirst().get();
        List<String> bookIds = current.getBookIds();
        bookIds.add(bookId);
    }

    public void delete(String id) {
        authors.removeIf(author -> author.getId().equals(id));
    }

    public Author findById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().get();
    }

    public List<Author> findAll() {
        return authors;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (authors.stream().anyMatch(author -> author.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}

package nixsolutions.com;

import nixsolutions.com.entity.Author;
import nixsolutions.com.entity.BaseEntity;
import nixsolutions.com.entity.Book;
import nixsolutions.com.entity.style.BookStyle;
import nixsolutions.com.service.AuthorService;
import nixsolutions.com.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private BookService bookService = new BookService();
    private AuthorService authorService = new AuthorService();

    public void start() {

        Author author = new Author();
        author.setName("test1");
        authorService.create(author);
        List<Author> authors = authorService.findAll();
        authors.forEach(System.out::println);

        Book book = new Book();
        book.setBookStyle(BookStyle.Detective);
        bookService.create(book);
        List<Book> books = bookService.findAll();
        books.forEach(System.out::println);

        String bookId = books.get(0).getId();
        String authorId = authors.get(0).getId();
        authorService.linkBook(authorId, bookId);

        book = new Book();
        book.setBookStyle(BookStyle.Fantastic);
        bookService.create(book);
        books = bookService.findAll();
        bookId = books.get(1).getId();
        authorService.linkBook(authorId, bookId);

        authors = authorService.findAll();
        authors.forEach(System.out::println);
        books = bookService.findAll();
        books.forEach(System.out::println);

        /*authorService.delete(authorId);

        System.out.println("after delete");
        authors = authorService.findAll();
        authors.forEach(System.out::println);
        books = bookService.findAll();
        books.forEach(System.out::println);*/

        List<BaseEntity> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int r = random.nextInt(2);
            if (r == 0) {
                list.add(new Author());
            } else {
                list.add(new Book());
            }
        }

        for (BaseEntity baseEntity : list) {
            System.out.println("baseEntity = " + baseEntity.getClass().getSimpleName());
            if (baseEntity instanceof Author) {
                Author owner = (Author) baseEntity;
                System.out.println("author = " + owner);
            }
            if (baseEntity instanceof Book) {
                Book car = (Book) baseEntity;
                System.out.println("book = " + car);
            }
        }
    }
}

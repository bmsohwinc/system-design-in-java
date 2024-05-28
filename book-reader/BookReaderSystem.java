import java.util.List;
import java.util.Map;


class BookSearchService {
    List<Book> search(String query) {  return null; }
}


class Book {
    String id;
    String title;
    String author;
    int pages;
}


class Library {
    Map<String, Book> books;
    BookSearchService bookSearchService;

    void addBook(String id, Book book) {}

    Book findBook(String id) { return books.get(id); }

    Book removeBook(String id) { return books.remove(id); }
}


class BookStats {
    String bookId;
    int readingTime;
    int currentPage;
}


class BookShelf {
    Map<String, BookStats> bookStats;
}


class User {
    String userId;
    BookShelf bookShelf;
    boolean member;
    Book currentBook;

    void borrowBook(String id, Library library) { /* Store in BookShelf */ }

    void readBook(String id) { /* Read from BookShelf */ }

    List<Book> searchBook(String id, Library library) { return List.of(); }
}


public class BookReaderSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.bookSearchService = new BookSearchService();

        User user = new User();
        user.bookShelf = new BookShelf();

        List<Book> books = user.searchBook("abc", library);
        user.borrowBook(books.get(0).id, library);
        user.readBook("abc");

    }

}

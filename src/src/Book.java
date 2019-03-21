public class Book implements Comparable<Book> {
    String title;

    public Book(String t) {
        title = t;
    }

    @Override
    public int compareTo(Book b) {
        Book book = (Book) b;
        return title.compareTo(book.title);
    }

    public String toString() {
        return title;
    }
}

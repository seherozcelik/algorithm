import java.util.Comparator;
import java.util.TreeSet;

public class TestTree2 {

    public static void main(String[] args) {
        new TestTree2().go();
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");

        TreeSet<Book> tree = new TreeSet<Book>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
        
        BookCompare bCompare = new BookCompare();
        TreeSet<Book> tree2 = new TreeSet<Book>(bCompare);
        
        tree2.add(b1);
        tree2.add(b2);
        tree2.add(b3);
        System.out.println(tree2);
    }
    
    public class BookCompare implements Comparator<Book>{

        @Override
        public int compare(Book o1, Book o2) {
            return o2.title.compareTo(o1.title);
        }
        
    }
}

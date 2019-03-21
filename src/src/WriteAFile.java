import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("hello foooo!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

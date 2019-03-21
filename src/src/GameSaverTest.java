import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaverTest {

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] { "bow", "sword", "dust" });
        GameCharacter two = new GameCharacter(200, "Troll", new String[] { "bare hans", "big ax" });
        GameCharacter three = new GameCharacter(120, "Magician", new String[] { "spells", "invisbility" });
        
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        one = null;
        two = null;
        three = null;
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();
            
            System.out.println(oneRestore.getType());
            System.out.println(twoRestore.getType());
            System.out.println(threeRestore.getType());
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

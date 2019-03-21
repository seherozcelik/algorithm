import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CityQuestion {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            in.readLine();
            String[] connsStr = in.readLine().split(" ");
            HashMap<Integer, String> conns = new HashMap<Integer, String>();
            for (int i = 0; i < connsStr.length+1; i++) {
                conns.put(i+1, connsStr[i]);
            }
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

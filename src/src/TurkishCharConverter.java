import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TurkishCharConverter {

    public static final String          u   = "\\u00fc";
    public static final String          U   = "\\u00dc";
    public static final String          s   = "\\u015f";
    public static final String          S   = "\\u015e";
    public static final String          i   = "\\u0131";
    public static final String          I   = "\\u0130";
    public static final String          c   = "\\u00e7";
    public static final String          C   = "\\u00c7";
    public static final String          g   = "\\u011f";
    public static final String          G   = "\\u011e";
    public static final String          o   = "\\u00f6";
    public static final String          O   = "\\u00d6";

    static final Map<Character, String> map = new HashMap<Character, String>();
    static {
        map.put('\u00fc', u);
        map.put('\u00dc', U);
        map.put('\u015f', s);
        map.put('\u015e', S);
        map.put('\u0131', i);
        map.put('\u0130', I);
        map.put('\u00e7', c);
        map.put('\u00c7', C);
        map.put('\u011f', g);
        map.put('\u011e', G);
        map.put('\u00f6', o);
        map.put('\u00d6', O);
    }

    public static void main(String[] args) {
        String str = getStringFromClipboard();
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String rep = map.get(str.charAt(i));
            if (rep == null) {
                System.out.print(str.charAt(i));
                newStr.append(str.charAt(i));
            } else {
                System.out.print(rep);
                newStr.append(rep);
            }
        }
        System.out.println();
        System.out.println(newStr.toString());
        //setStringToClipboard("\""+newStr.toString()+"\"");
        setStringToClipboard(newStr.toString());
    }

    public static String getStringFromClipboard() {

        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {

            String text = "";
            try {
                text = (String) transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return text;

        }
        return "";
    }

    // This method writes a string to the clipboard.
    public static void setStringToClipboard(String stringContent) {
        StringSelection stringSelection = new StringSelection(stringContent);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

}

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawPanel2 extends JPanel {

    private static final long serialVersionUID = -4268484063627175667L;

    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("bebek2.JPG").getImage(); //D:\HERSEY\güzelResimler\bebek2.JPG
        g.drawImage(image, 3, 4, this);
    }

}

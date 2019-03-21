import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

    private static final long serialVersionUID = -4268484063627175667L;

    public void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(20, 50, 100, 100);
    }

}

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyDrawPanel4 extends JPanel {

    private static final long serialVersionUID = -4268484063627175667L;

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        GradientPaint gradient = new GradientPaint(70, 70, Color.BLUE, 150, 150, Color.ORANGE);
        
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }

}

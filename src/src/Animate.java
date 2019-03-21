import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animate {
    int x = 1;
    int y = 1;

    public static void main(String[] args) {
        Animate gui = new Animate();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawP drawP = new MyDrawP();
        frame.getContentPane().add(drawP);
        frame.setSize(500, 250);
        frame.setVisible(true);
        for (int i = 0; i < 124; i++, y++) {
            x++;
            drawP.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
    }

    class MyDrawP extends JPanel {

        private static final long serialVersionUID = -4152917783045991270L;

        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 250);
            g.setColor(Color.blue);
            g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
        }
    }
}

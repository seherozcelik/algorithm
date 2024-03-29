import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {

    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();

    }

    public void go() {
        JFrame frame = new JFrame("seher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            
            drawPanel.repaint();
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanel extends JPanel {

        private static final long serialVersionUID = 9063289177407262174L;

        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            g.setColor(Color.GREEN);
            g.fillOval(x, y, 40, 40);
        }

    }
}

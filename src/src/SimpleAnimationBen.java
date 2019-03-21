import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimationBen {

    int         x = 50;
    int         y = 50;
    int         z = 400;
    JFrame      frame;
    MyDrawPanel drawPanel;

    public static void main(String[] args) {

        SimpleAnimationBen gui = new SimpleAnimationBen();
        gui.go();

    }

    public void go() {
        frame = new JFrame("seher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new MyDrawPanel();
        JButton rePlayButton = new JButton("replay");
        rePlayButton.addActionListener(new ColorListener());

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, rePlayButton);
        frame.setSize(580, 500);
        frame.setVisible(true);

        for (int i = 0; i < 70; i++) {
            x = x + 4;
            y = y + 4;
            z = z - 4;

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

            g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
            g.fillOval(x, y, 80, 80);
            g.fillOval(z, y, 80, 80);
        }

    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            x = 50;
            y = 50;
            z = 400;
            
            drawPanel.repaint();

            for (int i = 0; i < 70; i++) {


                x = x + 4;
                y = y + 4;
                z = z - 4;
                
                drawPanel.repaint();

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}

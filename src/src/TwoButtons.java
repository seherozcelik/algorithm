import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TwoButtons {
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListner());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label");

        MyDrawPanel3 drawPanel = new MyDrawPanel3();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    class LabelListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");
        }

    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }

    }
}

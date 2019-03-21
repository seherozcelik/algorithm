import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClientNew {

    JTextArea      incoming;
    JTextField     outgoing;
    BufferedReader reader;
    PrintWriter    writer;
    Socket         sock;

    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qscroller = new JScrollPane(incoming);
        qscroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qscroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qscroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        frame.setSize(800, 500);
        frame.setVisible(true);
    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            System.out.println("client run " + new Date());
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    incoming.append("server: " + message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("client cikiyor " + new Date());
        }

    }

    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String clientSays = outgoing.getText();
            writer.println(clientSays);
            incoming.append("client: " + clientSays + "\n");
            writer.flush();

            outgoing.setText("");
            outgoing.requestFocus();
        }

    }

    public static void main(String[] args) {
        new SimpleChatClientNew().go();
    }

}

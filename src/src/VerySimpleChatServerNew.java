import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class VerySimpleChatServerNew {

    JTextArea      incoming;
    JTextField     outgoing;
    PrintWriter    writer;
    BufferedReader reader;

    public class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String serverSays = outgoing.getText();
            writer.println(serverSays);
            incoming.append("server: " + serverSays + "\n");
            writer.flush();

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Server");
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

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        frame.setSize(800, 500);
        frame.setVisible(true);

        try {
            ServerSocket serverSock = new ServerSocket(5000);

            while (true) {
                Socket clientSock = serverSock.accept();
                writer = new PrintWriter(clientSock.getOutputStream());
                InputStreamReader streamReader = new InputStreamReader(clientSock.getInputStream());
                reader = new BufferedReader(streamReader);
                Thread readerThread = new Thread(new IncomingReader());
                readerThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            System.out.println("server run " + new Date());
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    incoming.append("client: " + message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("server cikiyor " + new Date());
        }

    }

    public static void main(String[] args) {
        VerySimpleChatServerNew server = new VerySimpleChatServerNew();
        server.go();
    }
}

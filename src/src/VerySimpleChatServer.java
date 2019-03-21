import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class VerySimpleChatServer {

    ArrayList clientOutputStreams;

    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket         sock;

        public ClientHandler(Socket clientSocket) {
            sock = clientSocket;
            try {
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    tellEveryone("-server tells everyone-" + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void go() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSock = new ServerSocket(5000);

            while (true) {
                Socket clientSock = serverSock.accept();

                PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                clientOutputStreams.add(writer);
                System.out.println(clientOutputStreams.size());

                Thread t = new Thread(new ClientHandler(clientSock));
                t.start();
                System.out.println("got a connection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            PrintWriter writer = (PrintWriter) it.next();
            writer.println(message);
            writer.flush();
        }
    }

    public static void main(String[] args) {
        VerySimpleChatServer server = new VerySimpleChatServer();
        server.go();
    }
}

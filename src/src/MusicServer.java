import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class MusicServer {

    ArrayList<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {

        ObjectInputStream in;
        Socket            clientSocket;

        public ClientHandler(Socket socket) {
            clientSocket = socket;
            try {
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Object o2 = null;
            Object o1 = null;
            System.out.println("server " + new Date());
            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();

                    System.out.println("read two objects " + new Date());
                    tellEveryone(o1, o2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void go() {
        clientOutputStreams = new ArrayList<ObjectOutputStream>();

        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                Socket clieSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clieSocket.getOutputStream());
                clientOutputStreams.add(out);

                Thread t = new Thread(new ClientHandler(clieSocket));
                t.start();

                System.out.println("get a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(Object one, Object two) {
        Iterator<ObjectOutputStream> it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            ObjectOutputStream out = (ObjectOutputStream) it.next();
            try {
                out.writeObject(one);
                out.writeObject(two);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

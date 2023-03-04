import java.io.*;
import java.net.Socket;

public class Connection {
    public Socket socket;
    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        DataInputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";

        while (!line.equals("bye"))
        {
            try
            {
                line = inp.readUTF();
                switch (line.split(" ")[0])
                {
                    case "hand":
                        break;
                    case "draw":
                        break;
                    case "sync":
                        break;
                    case "event":
                        break;
                }

            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        System.out.println("Closing connection");

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

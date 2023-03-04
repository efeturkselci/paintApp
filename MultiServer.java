// A Java program for a Server 
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MultiServer
{
    //initialize socket and input stream 
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    public static List<Connection> _conns = new ArrayList<Connection>();
    public boolean          exit     = false;
    public int position = 0;
    // constructor with port 
    public MultiServer()
    {
        // starts server and waits for a connection 
        try
        {
            server = new ServerSocket(2004);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");
            while (!exit) {
                try {
                    socket = server.accept();
                    System.out.println("Client accepted");
                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                }
                // new thread for a client

                _conns.add(new Connection(socket));
                _conns.get(position).run();
                position++;

            }
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
} 
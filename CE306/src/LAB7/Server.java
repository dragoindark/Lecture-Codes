package LAB7;

import java.io.*;
import java.util.*;
import java.net.*;
 
// Server class
public class Server 
{
    // Vector to store active clients
    static Vector<ClientHandler> clientsVector = new Vector<>();
     
    // counter for clients
    public static int clientCounter = 0;
 
    public static void main(String[] args) throws IOException 
    {
        // server is listening on port 3519
        InetAddress bindAddr = InetAddress.getByName("localhost");
        @SuppressWarnings("resource")
        ServerSocket ss = new ServerSocket(3519, 65, bindAddr);
        System.out.println("Server address is: " + ss.getInetAddress().getHostAddress());
        System.out.println("Server address is reachable: " + ss.getInetAddress().isReachable(1024));
        System.out.println("Local socket address is: " + ss.getLocalSocketAddress());
         
        Socket s;
         
        // running infinite loop for getting
        // client requests
        while (true) 
        {
            // Accept the incoming request
            s = ss.accept();
 
            System.out.println("New client request received : " 
			+ s.getInetAddress().getHostAddress() + ":" + s.getPort());
             
            // obtain input and output streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             
            System.out.println("Creating a new handler for this client...");
 
            // Create a new handler object for handling this request.
            ClientHandler clientHandler = new ClientHandler(s,"client" + clientCounter, dis, dos);
 
            // Create a new Thread with this object.
            Thread t = new Thread(clientHandler);
            
            // Add this client to active clients list
            System.out.println("Adding this client to active clients list. This is the client" + clientCounter + ".");
            clientsVector.add(clientHandler);
            
            System.out.print((clientsVector.size() < 1) ? "The only active client is: " : "Active clients are: ");
            for (ClientHandler client : clientsVector) 
            {
				System.out.print((clientsVector.lastElement().equals(client)) 
						? client.getName() + ".\n" 
						: client.getName() + ", ");
			}
 
            // start the thread.
            t.start();
 
            // increment counter for new client.
            clientCounter++;
 
        }
    }
}

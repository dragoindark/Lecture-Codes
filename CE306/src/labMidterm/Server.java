package labMidterm;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket socket;
	private ServerSocket server;
	private DataInputStream in;
	
	public Server(int port) throws IOException{
		server=new ServerSocket(5000);
		socket=server.accept();
		in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line=in.readUTF();
		System.out.println(line.length());
		socket.close();
		in.close();
		
	}
	
	public static void main(String[] args)throws IOException{
		new Server(5000);
	}
}

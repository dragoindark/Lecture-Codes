package labMidterm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private Socket socket;
	private Scanner input;
	private DataOutputStream out;
	
	public Client(String address,int port) throws UnknownHostException, IOException {
		socket = new Socket(address,port);
		input=new Scanner(System.in);
		out=new DataOutputStream(socket.getOutputStream());
		String line=input.nextLine();
		out.writeUTF(line);
		input.close();
		out.close();
		socket.close();
	}
	
	public static void main(String[] args)throws IOException{
		new Client("127.0.0.1",5000);
	}

}

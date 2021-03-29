package LAB10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws IOException {
		String hostName="Thael.com";
		int port=65534;
		DatagramSocket socket=new DatagramSocket();
		InetAddress localIP=InetAddress.getLocalHost();
		byte[] buffer=null;
		Scanner input=new Scanner(System.in);
		
		while(true) {
			System.out.println("Type deposit or withdraw than =(amount)");
			System.out.println("Example deposit=200");
			String operation=input.nextLine();
			if(operation.equalsIgnoreCase("exit")) {
				System.out.println("System.exit(0)");
				break;
			}
			buffer=new byte[66666];
			buffer=operation.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(buffer,buffer.length,localIP,65534);
			socket.send(sendPacket);
			buffer = new byte[65535]; 
            DatagramPacket recievePacket = 
                                 new DatagramPacket(buffer, buffer.length); 
            socket.receive(recievePacket); 
  
            System.out.println(new String(buffer,0,buffer.length)); 
		}
	}

}

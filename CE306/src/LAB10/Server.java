package LAB10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

	public static void main(String[]args) throws IOException {
		byte[] buffer=null;
		DatagramPacket recieved=null;
		DatagramPacket send=null;
		DatagramSocket socket=new DatagramSocket(65534);
		int savings=1000;
		boolean broke=false;
		
		while(true) {
			buffer=new byte[66666];
			recieved=new DatagramPacket(buffer,buffer.length);
			socket.receive(recieved);
			String message=new String(buffer,0,buffer.length);
			String value=message.substring(message.indexOf("=") + 1);
			value=value.trim();
			String operation=message.substring(0,message.indexOf("="));
			operation=operation.trim();
			message=message.trim();
			int newValue=Integer.parseInt(value);
			if(message.equalsIgnoreCase("exit")) {
				System.out.println("System.exit(0)");
				break;
			}else if(operation.equalsIgnoreCase("deposit")) {
				savings+=newValue;
			}else if(operation.equalsIgnoreCase("withdraw")) {
				if(savings-newValue>=0) {
					savings-=newValue;
				}else {
					broke=true;
				}
			}else {
				System.out.println("Illegal message no transactions");
			}
			String savingsString="";
			if(broke) {
				savingsString="YOU BROKE NO MONEY TO WITHDRAW";
			}else {
				savingsString=Integer.toString(savings);
			}
			buffer=savingsString.getBytes();
			
			send=new DatagramPacket(buffer,buffer.length,InetAddress.getLocalHost(),recieved.getPort());
			socket.send(send);
			
		}
	}
}

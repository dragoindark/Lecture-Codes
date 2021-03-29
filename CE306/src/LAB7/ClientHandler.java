package LAB7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

// ClientHandler class
public class ClientHandler implements Runnable
{
    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;
     
    // Constructor
    public ClientHandler(Socket s, String name,
                            DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin=true;
    }
    
    // Getters and setters
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
    public void run() 
    {
		DataOutputStream dOut;
		try {
			dOut = new DataOutputStream(s.getOutputStream());
			// Send first message

			String st = getAlphaNumericString(6);
			dOut.writeUTF(name + "#" + st);
			dOut.flush(); // Send off the data
			//this.s.close();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

        String received;
        String recipient = "";
        
        while (true) 
        {
            try
            {
                // receive the string
                received = dis.readUTF();
                //System.out.println(received);
                 
                if(received.equals("logout")){
                    this.isloggedin=false;
                    this.s.close();
                    break;
                }
                 
                // break the string into message and recipient part
                StringTokenizer st = new StringTokenizer(received, "#");
                String MsgToSend = st.nextToken();
                recipient = st.nextToken();
                System.out.println(MsgToSend);
 
                // search for the recipient in the connected devices list.
                // clientsVector is the vector storing client of active users
                for (ClientHandler mc : Server.clientsVector) 
                {
                    // if the recipient is found, write on its
                    // output stream
                    if (mc.name.equals(recipient) && mc.isloggedin==true) 
                    {
                        mc.dos.writeUTF(this.name + " : "+MsgToSend);
                        System.out.println("Removing " + mc.name + " from the active client list.");
                        Server.clientsVector.remove(mc);
                        break;
                    }
                }
            } 
            catch (IOException e) 
            {
            	//System.out.println("Waiting for message...");
            }   
        }
        
        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();
            this.s.close();
             
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
}
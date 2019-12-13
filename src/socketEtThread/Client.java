package socketEtThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client  { 
	
    public static void main(String[] args) throws IOException  { 
        try { 
            Scanner sc = new Scanner(System.in); 
              
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 
            //InetAddress ip = InetAddress.getByName("192.168.0.11");
            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5056); 
      
            // obtaining input and out streams 
            DataInputStream in = new DataInputStream(s.getInputStream()); 
            DataOutputStream out = new DataOutputStream(s.getOutputStream()); 
      
            // the following loop performs the exchange of 
            // information between client and client handler 
            while (true)  { 
                System.out.println(in.readUTF()); 
                String tosend = sc.nextLine(); 
                out.writeUTF(tosend); 
                  
                // If client sends exit,close this connection  
                // and then break from the while loop 
                if(tosend.equals("Exit")) { 
                    System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 
                  
                // printing date or time as requested by client 
                String received = in.readUTF(); 
                System.out.println(received); 
            } 
              
            // closing resources 
            sc.close(); 
            in.close(); 
            out.close(); 
        }
        catch(Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
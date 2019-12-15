package socket;

  
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  

public class Client  
{ 
	public static Thread t;
	public Client() {
		 try
	        { 
	           
	            InetAddress ip = InetAddress.getByName("localhost"); 
	      
	           
	            Socket s = new Socket(ip, 5056); 
	      
	            
	            DataInputStream dis = new DataInputStream(s.getInputStream()); 
	            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
	      
	           
	            Thread t = new ClientHandler(s, dis, dos); 
	            
	            
	            t.start(); 
	           
	        }catch(Exception e){ 
	            e.printStackTrace(); 
	        } 
	}
    public static void main(String[] args) throws IOException  
    { 
        try
        { 
            
            InetAddress ip = InetAddress.getByName("localhost"); 
      
           
            Socket s = new Socket(ip, 5056); 
      
           
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
      
           
            Thread t = new ClientHandler(s, dis, dos); 
            
         
            t.start(); 
          
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
} 
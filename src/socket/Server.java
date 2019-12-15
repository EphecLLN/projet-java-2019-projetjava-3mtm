package socket;

  
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

public class Server  
{ 
	public static Thread t;
	public Server() throws IOException{
		ServerSocket ss = new ServerSocket(5056); 
		//while (true)  
        //{ 
            Socket s = null; 
              
            try 
            { 
                
                s = ss.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                
                Thread t = new ClientHandler(s, dis, dos); 
  
               
                t.start(); 
              // t.interrupt();
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 

    public static void main(String[] args) throws IOException  
    { 
        
        ServerSocket ss = new ServerSocket(5056); 
          
        
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                
                s = ss.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                
                Thread t = new ClientHandler(s, dis, dos); 
  
                
                t.start(); 
                  
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
  

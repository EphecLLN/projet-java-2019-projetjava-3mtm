/**
 * 
 */
package p;
import java.net.*; 
import java.io.*;
/**
 * @author joachim
 *
 */
public class Client {

	/**
	 * @param args
	 */
	
	
	
	// initialize socket and input output streams 
    private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null; 
    public String line="";
 
    // constructor to put ip address and port 
    public Client(String address, int port) 
    { 
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        // string to read message from input 
       // String line = ""; 
  
        // keep reading until "Over" is input 
        while(line!= "Over") {
            try
            { 
                //line = input.readLine(); 
            	System.out.println(line);
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        }
         
  
        // close the connection 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

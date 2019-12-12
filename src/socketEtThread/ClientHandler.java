package socketEtThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler extends Thread  { 

    final DataInputStream in; 
    final DataOutputStream out; 
    final Socket s; 
      
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  { 
        this.s = s; 
        this.in = dis; 
        this.out = dos; 
    } 
  
    @Override
    public void run()  { 
        String received; 
  
        while (true)  { 
            try { 
                // Ask user what he wants 
            	out.writeUTF("What do you want?[Date | Time]..\n"+ 
                            "Type Exit to terminate connection."); 
                  
                // receive the answer from client 
                received = in.readUTF(); 
                  
                if(received.equals("Exit")) {  
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 
                  
   
                // write on output stream based on the 
                // answer from the client 
                switch (received) { 
                  
                    case "Date" : 

                        break; 
                          
                    case "Time" : 
 
                        break; 
                          
                    default: 
                    	out.writeUTF("Invalid input"); 
                        break; 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try { 
            // closing resources 
            this.in.close(); 
            this.out.close(); 
              
        }
        catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 
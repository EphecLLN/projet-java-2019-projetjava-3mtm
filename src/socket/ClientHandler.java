package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import modele.Plateau;


class ClientHandler extends Thread  
{ 
   
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    char tableauRef[][] = new char[9][9];
      
  

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  
    { 
    	tableauRef = Plateau.tableau;
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
    } 
  
    @Override
    public void run()  
    { 
        String received; 
        while (true){ 
            try { 
            	String envoi = "";
                /*try {
					this.wait();
					System.out.println("arret");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("arret refusé");
				}*/
                  if(Plateau.tableau!=tableauRef) {
                	  for(int i = 0 ; i < Plateau.tableau.length;i++) {
                		  for(int j = 0 ; j < Plateau.tableau[i].length;j++) {
                			  if(tableauRef[i][j] != Plateau.tableau[i][j]) {
                				  envoi+=i;
                				  envoi+=j;
                				  envoi+=Plateau.tableau[i][j];
                				  tableauRef[i][j] = Plateau.tableau[i][j];
                			  }
                		  /*envoi += Plateau.tableau[i][j];
                		  tableauRef[i][j] = Plateau.tableau[i][j];*/
                		  }
                	  }
                	  dos.writeUTF(envoi);
                	   
                  }
                // attend une reponse
                received = dis.readUTF();
                  
                if(received.equals("Exit")) 
                {  
                    System.out.println("Le client " + this.s + " veut interrompre..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
                
                
               // String r = received.substring(i,j+1);
                System.out.println("recu,interpretation...");
                Plateau.tableau[received.charAt(0)][received.charAt(1)]=received.charAt(2);
                //Plateau.tableau[received.charAt(2)][received.charAt(3)]=received.charAt(4);
                	/*for(int i = 0 ; i < Plateau.tableau.length;i++) {
              		  for(int j = 0 ; j < Plateau.tableau[i].length;j++) {
              			  String r = received.substring(i,j+1);
              			  System.out.println(r.charAt(i+j));
              		  Plateau.tableau[i][j] = r.charAt(i+j);
              		  tableauRef[i][j] =  r.charAt(i+j);
              		  }
              	  }*/
                
                  
               
                
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try{ 
            
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } }
   
}
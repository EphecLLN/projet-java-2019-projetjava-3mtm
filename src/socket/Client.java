package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static final int port = 9000;

	   public static void main(String[] args) throws Exception {
			
	        Socket socket = new Socket(args[0], port);
	        System.out.println("SOCKET = " + socket);

	        BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	        PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

	        Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        
	        while(true){
	            pred.println(str);          // envoi d'un message
	            str = sc.nextLine();
	            if(str.equals("END"))break;
	            //str = plec.readLine();      // lecture de l'écho
	        }
	        
	        System.out.println("END");     // message de terminaison
	        pred.println("END") ;
	        plec.close();
	        pred.close();
	        socket.close();
	   }
}

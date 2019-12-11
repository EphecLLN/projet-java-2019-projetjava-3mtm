package socketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Serveur {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	
			ServerSocket s = new ServerSocket(8000);
			Socket soc = s.accept();
			System.out.println(s);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));
			
			while (true) {
				String str = in.readLine();
				System.out.println("ECHO = " + str);
				out.println(str);
				if (str.equals("END")) break;
			}
			in.close();
			out.close();
			soc.close();

	}

}

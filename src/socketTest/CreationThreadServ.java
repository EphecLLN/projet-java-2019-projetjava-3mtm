package socketTest;

import java.io.IOException;

public class CreationThreadServ implements Runnable {
		  
	  
	  public void run() {

		  try {
			Serveur.main(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	  }
	  
}

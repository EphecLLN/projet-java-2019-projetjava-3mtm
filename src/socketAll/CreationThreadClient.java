package socketAll;

public class CreationThreadClient implements Runnable{

	 public void run() {
		  String[] args = {"127.0.0.1"};
		try {
			Client.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}

package socketAll;

public class TestThread {
	
	
	
	 public static void main(String[] args) {
            
              Thread t1 = new Thread(new CreationThreadServ());
              Thread t2 = new Thread(new CreationThreadClient());
              t1.start();
              t2.start();
		  }
		  
}

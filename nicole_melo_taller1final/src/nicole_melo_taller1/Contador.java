package nicole_melo_taller1;

public class Contador extends Thread {
	
	public int contador = 60;
	
	
	 public void run()
	   {
		 while(true) {
	      try {
	    	  
	    	  contador--;
	    	  //System.out.println(contador);
	    	  sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 }
	   }
}
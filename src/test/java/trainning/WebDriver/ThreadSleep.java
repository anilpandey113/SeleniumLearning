package trainning.WebDriver;

public class ThreadSleep {

	public static void sleep(long mill){
		
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

package threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ProcessPool implements Runnable {

	private String name;
	
	public ProcessPool (String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" is running");
		try {
			Thread.sleep((long)new Random().nextInt(10)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
public class ThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i< 15; i++) {
			executor.submit(new ProcessPool("Thread"+(i+1)));
		}
		System.out.println("Tasks started and running");
		executor.shutdown();
		try {
			//should be given after shutdown
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks must be completed by now");
	}

}

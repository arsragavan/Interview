package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessLatch implements Runnable {
	private CountDownLatch latch;
	
	
	public ProcessLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Running...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println(latch.getCount());
		
	}
}
public class Latches {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i = 0;i<15;i++) {
			executor.submit(new ProcessLatch(latch));
		}
		executor.shutdown();

	}

}

package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProdCons {
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	boolean produce = true;
	
	public void producer() {
		while(produce) {
			queue.offer(new Random().nextInt(100));
		}
	}
	
	public void consumer() {
		int count = 0;
		while(queue.size() > 0) {
			int temp = new Random().nextInt(100);
			if (queue.contains(temp)) {
				try {
					// queue.take will wait for an element to be available unlike remove which
					// throws ElementNotFoundException
					System.out.println("Removed : "+queue.take()+" elements = "+queue.toString()+" count = "+(++count));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		produce = false;
	}
}
public class ProducerConsumer {

	public static void main(String[] args) {
		final ProdCons prodCons = new ProdCons();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				prodCons.producer();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				prodCons.consumer();
			}
		});
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}

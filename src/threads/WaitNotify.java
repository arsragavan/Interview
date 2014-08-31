package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProdConsWN {
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);
	Object obj = new Object();
		
	public void produce() {
		int count = 0;
		synchronized (obj) {
			while(count < 100) {
				try {
					Thread.sleep(100);
					if (queue.size() > 7) {
						System.out.println("Wait till consumed");
						obj.wait(10000);
					}
					else {
						int temp = new Random().nextInt(100);
						queue.add(temp);
						System.out.println("Queue:"+queue.toString());
						count++;
						obj.notify();
					}
					
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void consume() {
		synchronized (obj) {
			while(queue.size() > 0) {
				try {
					Thread.sleep(100);
					if (queue.size() < 3) {
						System.out.println("Refill.. (produce)");
						obj.wait(10000);
					}
					else {
						queue.take();
						System.out.println("Queue:"+queue.toString());
						obj.notify();
					}
						
				}
				catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
		}
	}
}
public class WaitNotify {

	public static void main(String[] args) {
		final ProdConsWN pc = new ProdConsWN();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				pc.produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				pc.consume();
			}
		});
		
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}

}

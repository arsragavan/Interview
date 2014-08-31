package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProcAwaitSig {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void produce() {
		while(true) {
			try {
				Thread.sleep(1000);
				lock.lock();
				if (queue.size() > 8)
					condition.await();
				else
					queue.add(new Random().nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
		}	
	}
	
	public void consume() {
		while(true) {
			try {
				Thread.sleep(2000);
				lock.lock();
				if (queue.size() < 3)
					condition.signal();
				else {
					queue.take();
					System.out.println(queue.toString());
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
		}	
	}
}
public class AwaitSignalThreads {

	public static void main(String[] args) {
		final ProcAwaitSig pas = new ProcAwaitSig();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				pas.produce();
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				pas.consume();
				
			}
		});
		
		t1.start();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}

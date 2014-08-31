package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class IncProcessor {
	private int number = 0;
	Lock lock = new ReentrantLock();
	
	public void increment() {
		System.out.println("Before = "+checkLock(lock));
		lock.lock();
		System.out.println("After = "+checkLock(lock));
			for (int i = 0;i<10000;i++) {
				try {
					Thread.sleep(1);
					number++;
					//System.out.println(number);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		lock.unlock();
	}
	public int getNumber() {
		return number;
	}
	public boolean checkLock(Lock lock1) {
		boolean isLock = lock1.tryLock();
		if (isLock)
			lock1.unlock();
		return !isLock;
	}
}
public class ThreadLocks {

	public static void main(String[] args) {
		final IncProcessor inc = new IncProcessor();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				inc.increment();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				inc.increment();
				
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final val = "+inc.getNumber());
		

	}

}

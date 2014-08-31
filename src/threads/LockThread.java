package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Process {
	private Random random;
	private List<Integer> list1;
	private List<Integer> list2;
	
	private Object lock1;
	private Object lock2;
	
	public Process() {
		random = new Random();
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		lock1 = new Object();
		lock2 = new Object();
		
	}
	
	@Override
	protected void finalize() {
		
	}
	
	public void process1() {
		
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
		
	}
	public void process2() {
		
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	public void process() {
		for(int i = 0;i<1000;i++) {
			process1();
			process2();
		}
		
	}
}

public class LockThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				new Process().process();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				new Process().process();
				
			}
		});
		long start = System.currentTimeMillis();
		try {
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			long end = System.currentTimeMillis();
			System.out.println("Total time = "+(end-start));
		}
		catch(Exception e ) {
			
		}
		finally {
			
		}

	}

}

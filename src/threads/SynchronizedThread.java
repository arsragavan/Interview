package threads;

class IncProcess extends Thread {
	private static int count;
	
	public IncProcess() {
		run();
	}
	
	public synchronized void inc() {
		count++;
	}
	@Override
	public void run() {
		for (int i = 0;i<10000;i++) {
			try {
				Thread.sleep(1);
				inc();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getCount() {
		return count;
	}
}

public class SynchronizedThread {

	public static void main(String[] args) {
		IncProcess inc1 = new IncProcess();
		IncProcess inc2 = new IncProcess();
		
		//inc1.start();
		//inc2.start();
		
		try {
			inc1.join();
			inc2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Latest count value = "+inc1.getCount());
	}
}

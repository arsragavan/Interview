package threads;

class ThreadClass extends Thread {
	
	@Override
	public void run() {
		for (int i = 0;i<10;i++) {
			
			try {
				long wait = (long) (i*1000);
				System.out.println(this.getName()+" "+i+", sleep = "+wait);
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}	
}

class ThreadInterface implements Runnable {

	@Override
	public void run() {
		for (int i = 0;i<10;i++) {
			
			try {
				long wait = (long) (Math.random()*10000);
				System.out.println(Thread.currentThread().getName()+" "+i+", sleep = "+wait);
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}		
	}
}

public class CreateThreads {

	public static void main(String[] args) {
		ThreadClass thread1 = new ThreadClass();
		thread1.start();
		
		Thread thread2 = new Thread(new ThreadInterface());
		thread2.start();
		
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0;i<10;i++) {
					
					try {
						long wait = (long) (Math.random()*10000);
						System.out.println(Thread.currentThread().getName()+" "+i+", sleep = "+wait);
						Thread.sleep(wait);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		thread3.start();
		
		Thread thread4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ThreadClass innerThread = new ThreadClass();
				innerThread.start();				
			}
		});
		thread4.start();
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread4.setPriority(Thread.MIN_PRIORITY);
	}
}

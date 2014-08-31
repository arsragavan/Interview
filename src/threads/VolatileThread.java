package threads;

import java.util.Scanner;

class Processor extends Thread {
	//To get the latest updated value
	private volatile int wait;
	public Processor() {
		wait = 1;
	}	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Waiting for :"+wait);
				if (wait == 0) {
					System.out.println(this.getName()+" can't wait anymore");
					break;
				}
				Thread.sleep((long)wait*1000L);
				System.out.print("Wait "+this.getName()+" for:");
				Scanner scanner = new Scanner(System.in);
				wait = Integer.parseInt(scanner.nextLine());
			} catch (InterruptedException e) {
				System.out.println(this.getName()+" Interrupted");
			}
						
		}			
	}
}
public class VolatileThread {

	public static void main(String[] args) throws InterruptedException {
		Processor pid1 = new Processor();
		pid1.setName("PID1");
		pid1.start();
		
		Thread.sleep(10000);
		
		Processor pid2 = new Processor();
		pid2.setName("PID2");
		pid2.start();
		
	}

}

package threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
	private long balance;
	private Lock readLock = new ReentrantLock();
	private Lock updLock = new ReentrantLock();

	// All the locks should happen at the same method to avoid deadlocks
	private void acquireLocks(Lock lock1, Lock lock2) {

		while (true) {
			boolean tryLock1 = lock1.tryLock();
			boolean tryLock2 = lock2.tryLock();
			if (tryLock1 && tryLock2) {
				return;
			} else if (tryLock1) {
				lock1.unlock();
			} else if (tryLock2) {
				lock2.unlock();
			}
		}

	}

	public Account(int balance) {
		this.balance = balance;
	}

	public long getBalance() {

		acquireLocks(readLock, updLock);
		long amt = balance;
		readLock.unlock();
		updLock.unlock();
		return amt;
	}

	public void debit(int amt) {
		acquireLocks(updLock, readLock);
		System.out.println("Amt withdrawn:" + amt);
		balance -= amt;
		updLock.unlock();
		readLock.unlock();
	}

	public void credit(long amt) {
		acquireLocks(updLock, readLock);
		System.out.println("Amt deposited:" + amt);
		balance += amt;
		updLock.unlock();
		readLock.unlock();
	}
}

public class Deadlocks {

	public static void main(String[] args) {
		final Account acc = new Account(0);
		final Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
						acc.debit(new Random().nextInt());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(100);
						acc.credit(new Random().nextLong());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (t1.isAlive() || t2.isAlive()) {
					try {
						Thread.sleep(100);
						System.out.println("Current Bal = " + acc.getBalance());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t3.start();
		t1.start();
		t2.start();

	}

}

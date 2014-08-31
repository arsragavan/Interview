package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

class Game {
	
	private BlockingQueue<Integer> queue;
	private Semaphore semaphore;
	
	public Game() {
		queue = new ArrayBlockingQueue<>(10);
		semaphore = new Semaphore(10);
	}
	
	public void play(int playerNo, Integer waiting) {
		
		try {
			semaphore.acquire();
			queue.add(playerNo);
			Thread.sleep(waiting);
			System.out.println("Current Players:"+queue.toString());
			queue.remove(playerNo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaphore.release();
		}
	}
}
public class MultiplayerSemaphore {

	public static void main(String[] args) {
		
		ExecutorService executors = Executors.newCachedThreadPool();
		final Game game = new Game(); 
		
		for (int i = 0;i<30;i++) {
			final int playerNo = i;
			executors.submit(new Runnable() {
				
				@Override
				public void run() {
					ExecutorService executors = Executors.newCachedThreadPool();
					Future<Integer> future = executors.submit(new Callable<Integer>() {

						@Override
						public Integer call() throws Exception {
							return (new Random().nextInt(10)*1000);
						}
					});
					try {
						game.play(playerNo,future.get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
					executors.shutdown();
				}
			});			
		}
		executors.shutdown();		
	}
}

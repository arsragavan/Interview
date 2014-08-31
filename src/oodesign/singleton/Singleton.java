package oodesign.singleton;

import java.io.Serializable;
import java.util.Random;

class SinglePlayer implements Serializable {

	private static final long serialVersionUID = 9008672196576331066L;
	private static SinglePlayer playerInstance;
	String name;

	public static synchronized SinglePlayer getPlayerInstance(String name) {

		if (playerInstance == null) {
			playerInstance = new SinglePlayer();
			playerInstance.name = name;
		}

		return playerInstance;
	}

	public void play() {
		System.out.println(name + " is playing");
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Object readResolve() {
		return playerInstance;
	}
	
}

public class Singleton {

	public static void main(String[] args) {

		Thread p1 = new Thread(new Runnable() {

			@Override
			public void run() {
				SinglePlayer p1 = SinglePlayer.getPlayerInstance("P1");
				p1.play();
			}
		});

		Thread p2 = new Thread(new Runnable() {

			@Override
			public void run() {
				SinglePlayer p2 = SinglePlayer.getPlayerInstance("P2");
				p2.play();
			}
		});

		p1.start();
		p2.start();

	}

}

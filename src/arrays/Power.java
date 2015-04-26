package arrays;

import java.util.Scanner;

public class Power {

	public static int pPowerq(int n) {
		double p = 2;
		while (p <= Math.sqrt(n)) {
			double q = Math.log(n) / Math.log(p);
			if (q == Math.floor(q)) {
				return 1;
			}
			p++;
		}
		return 0;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println(pPowerq(scanner.nextInt()));
		scanner.close();

	}
}

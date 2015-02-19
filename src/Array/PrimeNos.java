package Array;

import java.util.Scanner;

public class PrimeNos {

	public static boolean[] getAllPrimeNos(int n) {

		boolean[] primeNos = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			primeNos[i] = true;
		primeNos[0] = false;
		primeNos[1] = false;
		int no = 2;
		while (no <= Math.sqrt(n)) {
			int i = 2;
			int num = no * i;
			while (num <= n) {
				primeNos[num] = false;
				i++;
				num = no * i;
			}
			no++;
		}
		return primeNos;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		for (boolean isPrime : getAllPrimeNos(scanner.nextInt())) {
			if (isPrime)
				System.out.println(i);
			i++;
		}
		scanner.close();
	}
}

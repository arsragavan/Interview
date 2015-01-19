package Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ticket {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long m = scanner.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});
		for (int i = 0; i < n; i++)
			pq.add(scanner.nextInt());
		scanner.close();
		long profit = 0;
		for (long k = 0; k < m; k++) {
			int count = pq.remove();
			profit += count;
			count--;
			if (count > 0)
				pq.add(count);
		}
		System.out.println(profit);
	}
}

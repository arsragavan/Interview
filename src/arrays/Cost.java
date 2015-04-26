package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Gear {
	Integer R;
	int C;
	int index;

	public Gear(int r, int c, int index) {
		R = r;
		C = c;
		this.index = index;
	}

}

public class Cost {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int D = scanner.nextInt();
		int[] R = new int[n];
		int[] C = new int[n];
		List<Gear> gearList = new ArrayList<Gear>();
		for (int i = 0; i < n; i++)
			R[i] = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			C[i] = scanner.nextInt();
			gearList.add(new Gear(R[i], C[i], i + 1));
		}
		PriorityQueue<Gear> pq = new PriorityQueue<Gear>(
				new Comparator<Gear>() {

					@Override
					public int compare(Gear o1, Gear o2) {
						return 0;
					}
				});

		Collections.sort(gearList, new Comparator<Gear>() {

			@Override
			public int compare(Gear o1, Gear o2) {
				return o1.R.compareTo(o2.R);
			}
		});
		int[] output = new int[n];
		for (Gear geari : gearList) {
			if (geari.R + gearList.get(gearList.size() - 1).R < D)
				output[geari.index - 1] = 0;
			int cost = Integer.MAX_VALUE;
			int radius = Integer.MIN_VALUE;
			int index = -1;
			for (Gear gearj : gearList) {
				if (geari.R + gearj.R >= D) {
					if (gearj.C < cost) {
						output[geari.index - 1] = gearj.index;
						cost = gearj.C;
						radius = gearj.R;
						index = gearj.index;
					} else if (gearj.C == cost) {
						if (gearj.R > radius) {
							cost = gearj.C;
							output[geari.index - 1] = gearj.index;
							radius = gearj.R;
							index = gearj.index;
						} else if (gearj.R == radius) {
							if (gearj.index < index) {
								cost = gearj.C;
								output[geari.index - 1] = gearj.index;
								radius = gearj.R;
								index = gearj.index;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");
	}

}

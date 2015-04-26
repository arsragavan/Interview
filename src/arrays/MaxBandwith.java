package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Entry {

	Integer time;
	boolean isStart;
	int bw;

	public Entry(Integer time, boolean isStart, int bw) {
		this.time = time;
		this.isStart = isStart;
		this.bw = bw;
	}
}

public class MaxBandwith {

	private static int getMaxBW(List<Entry> entries) {
		int maxBW = 0;
		int bw = 0;
		entries.sort(new Comparator<Entry>() {

			@Override
			public int compare(Entry o1, Entry o2) {
				return o1.time.compareTo(o2.time);
			}
		});
		for (Entry entry : entries) {
			if (entry.isStart) {
				bw += entry.bw;
				if (maxBW < bw)
					maxBW = bw;
			} else
				bw -= entry.bw;
		}
		return maxBW;
	}

	public static void main(String[] args) {
		List<Entry> entries = new ArrayList<Entry>();
		entries.add(new Entry(0, true, 100));
		entries.add(new Entry(10, false, 100));
		entries.add(new Entry(5, true, 200));
		entries.add(new Entry(15, false, 200));
		entries.add(new Entry(10, true, 300));
		entries.add(new Entry(20, false, 300));
		entries.add(new Entry(100, true, 10));
		entries.add(new Entry(2000, false, 10));
		entries.add(new Entry(5000, true, 1000));
		entries.add(new Entry(10000, false, 1000));
		System.out.println(getMaxBW(entries));

	}

}

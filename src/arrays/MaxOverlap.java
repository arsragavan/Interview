package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
	private int start;
	private int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
}

class Num {
	Integer n;
	boolean isStart;

	public Num(Integer n, boolean isStart) {
		this.n = n;
		this.isStart = isStart;
	}

	@Override
	public String toString() {
		return n + "";
	}

}

public class MaxOverlap {

	public static int getMaxOverlap(List<Interval> list) {

		List<Num> nums = new ArrayList<Num>();
		for (Interval i : list) {
			nums.add(new Num(i.getStart(), true));
			nums.add(new Num(i.getEnd(), false));
		}
		nums.sort(new Comparator<Num>() {
			public int compare(Num n1, Num n2) {
				return n1.n.compareTo(n2.n);

			}
		});
		int max = 0;
		int start = nums.get(0).n;
		int count = 0;
		System.out.println(nums);
		for (Num n : nums) {
			if (n.isStart) {
				// setting the start value
				if (count == 0)
					start = n.n;
				count++;
			} else {
				count--;
				// all overlap start and end finished, so calculate current
				// overlap
				if (count == 0)
					max = Math.max(max, n.n - start);
			}
		}
		return max;
	}

	public static void main(String[] args) {

		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 4));
		list.add(new Interval(-2, 3));
		list.add(new Interval(9, 10));

		System.out.println(getMaxOverlap(list));

	}

}

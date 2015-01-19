package dp;

//Ugly nos are numbers whose only prime factors are 2,3 and 5
public class Uglynos {

	public static long getKthUglyNo(int k) {
		long[] uglyNos = new long[k];
		uglyNos[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		for (int i = 1; i < k; i++) {
			if (uglyNos[i2] * 2 <= uglyNos[i3] * 3
					&& uglyNos[i2] * 2 <= uglyNos[i5] * 5) {
				uglyNos[i] = uglyNos[i2] * 2;
				i2++;
			} else if (uglyNos[i3] * 3 <= uglyNos[i5] * 5) {
				uglyNos[i] = uglyNos[i3] * 3;
				i3++;
			} else {
				uglyNos[i] = uglyNos[i5] * 5;
				i5++;
			}
			System.out.println(uglyNos[i]);
		}
		return uglyNos[k - 1];

	}
	public static void main(String[] args) {

		System.out.println(getKthUglyNo(20));

	}

}

package arrays;

import java.math.BigDecimal;

public class Test {

	/**
	 * 
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		BigDecimal input = new BigDecimal(99998);
		long i = 2;
		while (true) {
			BigDecimal d = new BigDecimal(Long.toBinaryString(i));
			// System.out.println(i + "=" + d);
			if (d.compareTo(input) >= 0
					&& d.remainder(input) == BigDecimal.ZERO) {
				System.out.println(d);
				break;
			}
			i++;
		}
		long end = System.currentTimeMillis();
		float l = 6.0f;
		float m = 1.4f;
		System.out.println(l % m);

		System.out.println("Time = " + (end - start));
	}
}

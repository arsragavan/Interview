package hr;

public class Solution {
	public static double pow(double x, int n) {
		double factor = 1;
		if (n == Integer.MAX_VALUE) {
			factor = x;
			n--;
		}
		return factor * pow(x, n, new Double[Math.abs(n) + 1]);
	}

	public static double pow(double x, int n, Double[] p) {
		if (n < 0)
			return 1 / pow(x, n * (-1));
		else if (p[n] == null) {
			if (n == 0)
				p[n] = 1.0;
			else if (n == 1)
				p[n] = x;
			else
				p[n] = pow(x, n / 2, p) * pow(x, n - (n / 2), p);
		}
		return p[n];
	}

	public static void main(String[] args) {
		System.out.println(pow(0.00001, 2147483647));
	}
}
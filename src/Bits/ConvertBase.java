/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bits;

public class ConvertBase {

	public static String convert(float n, int b) {
		int real = (int) n;
		float fraction = n - real;
		String output = ".";
		for (int i = 0; i < 10; i++) {
			if (fraction == 0)
				break;
			else {
				fraction *= 2;
				if (fraction >= 1) {
					output += "1";
					fraction -= 1;
				} else
					output += "0";
			}
		}
		return convert(real, b) + output;

	}
	public static String convert(int n, int b) {
		if (n < b)
			return String.valueOf(n);
		return convert(n / b, b) + String.valueOf(n % b);
	}
	public static void main(String args[]) {
		System.out.println(convert(11.0f, 2));
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bits;

public class ConvertBase {
	public static void convert(int n, int b) {
		if (n >= b)
			convert(n / b, b);
		else {
			System.out.print(n);
			return;
		}
		System.out.print(n % b);
	}
	public static void main(String args[]) {
		convert(31, 2);
	}
}

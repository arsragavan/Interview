/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package strings;

public class ReverseWords {
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();

	}

	public static void reverseString(char[] str, int p, int q) {
		while (p < q) {
			char temp = str[p];
			str[p] = str[q];
			str[q] = temp;
			p++;
			q--;
		}
	}

	public static String reverseWords2(String s) {
		char[] str = s.toCharArray();
		int p = 0;
		int q = str.length - 1;
		reverseString(str, p, q);
		p = 0;
		for (q = 0; q < str.length; q++) {
			if (str[q] == ' ') {
				reverseString(str, p, q - 1);
				p = q + 1;
			}
		}
		reverseString(str, p, q - 1);
		q = 0;
		char[] strO = new char[str.length];
		for (p = 0; p < str.length; p++) {
			if (str[p] == ' ') {
				while (p < str.length && str[p] == ' ')
					p++;
				p--;
			}
			strO[q++] = str[p];
		}
		return new String(strO).trim();
	}

	public static String reverseWords(String str) {
		String[] strArr = str.split("\\s");
		int i = 0;
		while (i < strArr.length) {
			strArr[i] = reverse(strArr[i]);
			i++;
		}
		i = 0;
		str = "";
		while (i < strArr.length) {
			str += strArr[i] + " ";
			i++;
		}
		return str.trim();
	}

	public static int atoi(String str) {
		int num = 0;

		int i = 0;
		while (i < str.length()) {

			if ((int) str.charAt(i) < 48 || (int) str.charAt(i) > 57) {
				System.out.println("Error");
				num = 0;
				break;
			}

			num = num * 10 + (int) str.charAt(i) - '0';
			i++;
		}

		return num;
	}

	public static void main(String args[]) {
		System.out.println(reverseWords(reverse("Hello world")));
		System.out.println("" + atoi("034390"));

		System.out.println(reverseWords2("   a   b "));
		System.out.println(reverseWords2("hello world!"));
	}

}

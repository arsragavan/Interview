package strings;

public class Combinations {

	// k - size of combination - if all needed k should be set to length of
	// input

	public static void combinations(String input, int k, int currentSize,
			String output) {
		if (currentSize == k) {
			System.out.println(output);
		} else {
			for (int i = 0; i < input.length(); i++)
				combinations(input, k, currentSize + 1,
						output + input.charAt(i));
		}
	}

	public static void main(String[] args) {

		combinations("abc", 2, 0, "");

	}

}

package strings;

public class StringToNumber {

	public static Long convertToNum(String input) {
		Long result = (long) 0;
		int i = 0;
		boolean isNegative = false;
		if (input.charAt(i) == '-') {
			i++;
			isNegative = true;
		}
		for (; i < input.length(); i++) {
			int digit = input.charAt(i);
			digit -= 48;
			if (digit >= 0 && digit <= 9)
				result = result * 10 + digit;
			else {
				System.out.println("Invalid Input");
				return null;
			}

		}
		if (isNegative)
			result *= -1;
		return result;
	}

	public static void main(String[] args) {

		String input = "938938jk99";
		System.out.println(convertToNum(input));

		input = "-819273921739821639821";
		System.out.println(convertToNum(input));

	}
}

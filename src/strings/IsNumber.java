package strings;

public class IsNumber {

	public static boolean isNumber(String str) {
		int n = str.length();
		int i = 0;
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			if (n == 1)
				return false;
			i++;
		}
		boolean isDecimal = false;
		while (i < n) {
			char ch = str.charAt(i);
			if (!Character.isDigit(ch)) {
				if (ch != '.' || isDecimal || i == n - 1)
					return false;
				isDecimal = true;
				if (i == 0 || (i > 0 && !Character.isDigit(str.charAt(i - 1))))
					return false;
			}
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "-100.0";
		System.out.println(isNumber(input));
		System.out.println(input.matches("\\d.*"));
	}
}

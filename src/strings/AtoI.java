package strings;

public class AtoI {

	public static double atoi(String str) {
		double real = 0;
		double num = 1;
		int i = 0;
		if (str.charAt(0) == '-')
			i = 1;
		for (;i<str.length();i++) {
			if (Character.isDigit(str.charAt(i)))
				real = real*10+Character.getNumericValue(str.charAt(i));
			else if (str.charAt(i) == '.')
				break;
			else
				return 0;
		}
		double decimal = 0;
		int count = 0;
		for (i++;i<str.length();i++) {
			if (Character.isDigit(str.charAt(i))) {
				decimal = decimal*10+Character.getNumericValue(str.charAt(i));
				count++;
			}	
			else
				return 0;
		}
		decimal = decimal/(Math.pow(10, count));
		num = (real+decimal);
		if (str.charAt(0) == '-')
			num *= -1;
		return num;
	}
	public static void main(String[] args) {
		System.out.println(atoi("-125"));			
	}

}

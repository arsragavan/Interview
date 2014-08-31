package strings;

public class ConsecutiveCount {

	public static String altCount(String str) {
		String output = "";
		str = str.toUpperCase();
		
		for(int i = 0;i<str.length();i++) {
			int count = 1;
			output += str.charAt(i);
			while (i< str.length()-1 && str.charAt(i+1) == str.charAt(i)) {
				i++;
				count++;
			}
			output +=count;
		}
		return output;
	}
	public static String count(String str) {
		
		StringBuilder strB = new StringBuilder(str.toUpperCase());
		int count = 1;
		for(int i = 0;i<strB.length();i++) {
			if (i < strB.length()-1 && strB.charAt(i+1) == strB.charAt(i)) {
				strB.deleteCharAt(i);
				i--;
				count++;
			}
			else {
				strB.insert(i+1, count);
				count = 1;
				i++;
			}
		}
		return strB.toString();
	}
	public static void main(String[] args) {
		System.out.println(count("aaabccddeeddd"));
		System.out.println(altCount("aaabccddeeddd"));
	}

}

package strings;

public class Vowels {

	public static String removeVowels(String str) {
		return str.replace("a", "").replace("e", "").replace("i", "")
				.replace("o", "").replace("u", "");
	}
	public static void main(String args[]) {
		System.out.println(removeVowels("Hello World! How are you ?"));
	}
}

package strings;

public class LowerUpperCombination {

	public static void printLowerUpperComb(String prefix,String str) {
		if (str.length() == 0) {
			System.out.println(prefix);
			return;
		}
		if (Character.isAlphabetic(str.charAt(0))) {
			printLowerUpperComb(prefix+str.substring(0,1).toLowerCase(),str.substring(1));
			printLowerUpperComb(prefix+str.substring(0,1).toUpperCase(),str.substring(1));
		}
		else
			printLowerUpperComb(prefix+str.substring(0,1),str.substring(1));		
	}
	public static void main(String[] args) {
		printLowerUpperComb("","0ab");

	}

}

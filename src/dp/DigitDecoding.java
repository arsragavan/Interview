package dp;

import java.util.ArrayList;
import java.util.List;

public class DigitDecoding {

	public static List<String> decode(String str) {

		List<String> output = new ArrayList<>();
		if (str == null || str.equals("")) {
			output.add("");
		} else {
			for (int i = 1; i <= str.length(); i++) {
				int number = Integer.parseInt(str.substring(0, i));
				if (number < 25)
					for (String rest : decode(str.substring(i)))
						output.add((char) (65 + number) + rest);
				else
					break;
			}
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(decode("00121"));
	}

}

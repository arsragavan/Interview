package dp;

public class EditDistance {

	private static int getEditDistance(String str1, String str2) {
		int[][] result = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 && j == 0)
					result[i][j] = 0;
				if (i == 0)
					result[i][j] = j;
				else if (j == 0)
					result[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					result[i][j] = result[i - 1][j - 1];
				else
					result[i][j] = Math.min(result[i - 1][j - 1],
							Math.min(result[i - 1][j], result[i][j - 1])) + 1;
			}
		}
		return result[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		System.out.println(getEditDistance("sunday", "saturdays"));
	}
}
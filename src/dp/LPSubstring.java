package dp;

public class LPSubstring {

	public static int lpSubstring(String str) {
		int[][] pali = new int[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (i > j)
					pali[i][j] = 0;
				else if (i == 1) {
					if (i == j)
						pali[i][j] = 1;
					else
						pali[i][j] = 0;
				} else if (str.charAt(i) == str.charAt(j)) {
					if (i == 2)
						pali[i][j] = 2;
					else
						pali[i][j] = pali[i - 1][j - 1] + 2;
				} else
					pali[i][j] = 0;
			}
		}
		return pali[str.length() - 1][str.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(lpSubstring("AxAb"));

	}

}

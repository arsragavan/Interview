package dp;

public class LPSubstring {

	public static int lpSubstring(String str) {
		int[][] pali = new int[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++)
			for (int j = 0; j < str.length(); j++)
				pali[i][j] = 0;
		for (int i = 0; i < str.length(); i++)
			pali[i][i] = 1;
		for (int i = 1; i < str.length(); i++)
			if (str.charAt(i) == str.charAt(i - 1))
				pali[i - 1][i] = 2;

		for (int j = 2; j < str.length(); j++)
			for (int i = j; i < str.length(); i++)
				if (str.charAt(i - j) == str.charAt(i)
						&& pali[i - j + 1][i - 1] != 0)
					pali[i - j][i] = pali[i - j + 1][i - 1] + 2;
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (max < pali[i][j])
					max = pali[i][j];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(lpSubstring("AxAbyAxb"));

	}

}

package misc;

public class Tennis {

	private static int getNoOfMatches(int n) {
		if (n <= 1)
			return 0;
		else
			return n / 2 + getNoOfMatches(n - n / 2);

	}

	public static void main(String[] args) {
		System.out.println(getNoOfMatches(3));

	}

}

package misc;

public class MaxBraceDepth {

	public static int maxDepth(String str) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				count++;
				if (max < count)
					max = count;
			} else if (ch == ')')
				count--;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxDepth("abc(123(xyz))m(((n)))o"));

	}

}

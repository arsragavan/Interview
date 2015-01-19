package dp;

public class Crossword {

	static char[][] matrix = { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' },
			{ 'l', 'm', 'n', 'o' }, { 'k', 'l', 'm', 'n' },
			{ 'f', 'g', 'h', 'i' } };

	public static boolean findWord(String str, String found, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j < matrix[0].length)
			return false;
		if (found.equals(str))
			return true;
		if (matrix[i][j] == str.charAt(0)) {

		} else if (matrix[i][j] == str.charAt(found.length())) {
			findWord(str, found + matrix[i][j], i, j);
		}
		return false;
	}

	public static void main(String[] args) {

	}

}

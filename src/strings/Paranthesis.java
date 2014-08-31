package strings;

public class Paranthesis {

	public static void printParanthesis(int l, int r, String parans) {
		if (l == 0 && r == 0)
			System.out.println(parans);	
		else {
			if (l>0)
				printParanthesis(l-1, r, parans+"(");
			if (r > l)
				printParanthesis(l, r-1, parans+")");
		}
	}
	public static void main(String[] args) {
		printParanthesis(3, 3, "");

	}

}

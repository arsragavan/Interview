package QueueStack;

import java.util.Stack;

public class Postfix {

	public static int evalPostFix(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				stack.push(Integer.parseInt(String.valueOf(ch)));
			} else {
				int n2 = stack.pop();
				int n1 = stack.pop();
				stack.push(result(n1, n2, ch));
			}
		}
		return stack.pop();
	}

	public static int result(int n1, int n2, char operator) {
		if (operator == '+')
			return n1 + n2;
		if (operator == '-')
			return n1 - n2;
		if (operator == '*')
			return n1 * n2;
		if (operator == '/')
			return n1 / n2;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(evalPostFix("128*+3-"));

	}

}

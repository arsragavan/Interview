package misc;

import java.util.Scanner;

class DivideByZero extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "You can't divide by zero";
	}

	public String returnNAN() {
		return "NaN";
	}
}

public class CustomException {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter num1:");
		int n1 = scanner.nextInt();
		System.out.println();
		System.out.print("Enter num2:");
		int n2 = scanner.nextInt();
		
		try {
			if (n2 == 0)
				throw new DivideByZero();
			System.out.println("Answer = "+(n1/n2));
		}
		catch(DivideByZero ex) {
			System.out.println(ex.getMessage());
			System.out.println("Answer="+ex.returnNAN());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

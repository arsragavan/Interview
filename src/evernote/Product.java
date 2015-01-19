package evernote;

import java.util.Scanner;

public class Product {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Integer count = Integer.parseInt(scanner.nextLine());
		int [] input = new int[count];
		for(int i = 0;i<count;i++)
			input[i] = Integer.parseInt(scanner.nextLine());
		scanner.close();
		int [] front = new int[count];
		int [] rear = new int[count];
		front [0] = rear[count-1] = 1;
		for (int i = 1;i<count;i++)
			front [i] = front[i-1]*input[i-1];
		for (int i = count-2;i>=0;i--)
			rear[i] = rear[i+1]*input[i+1];
		for(int i = 0;i<count;i++)
			System.out.println(front[i]*rear[i]);
	}
}

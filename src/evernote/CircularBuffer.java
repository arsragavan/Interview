package evernote;

import java.util.Scanner;
import java.util.regex.Pattern;

class CircularLL {
	
	private String line;
	private CircularLL next;
	public static int capacity;
	private static CircularLL header;
	
	public static void insert(String line) {
		CircularLL newNode = new CircularLL();
		newNode.line = line;
		if (header == null){
			header = new CircularLL();
			header.next = newNode;
		}
		else {
			int count = 0;
			CircularLL temp = header;
			while(count<capacity && temp.next!=header) {
				temp = temp.next;
				count++;
			}
			temp.next=newNode;
			if (count == capacity) {
				header.next = header.next.next;
			}
		}
		newNode.next = header;
	}
	
	public static void print() {
		if (header!= null) {
			CircularLL temp = header.next;
			while(temp!= header) {
				System.out.println(temp.line);
				temp = temp.next;
			}
		}
	}
	
	public static void delete(int n) {
		if (header!= null) {
			CircularLL temp = header.next;
			while(n>0 && temp!=header) {
				n--;
				temp = temp.next;
			}
			header.next = temp;
		}
	}
}
public class CircularBuffer {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		while(true) {
			count++;
			String input = scanner.nextLine();
			if (count == 1){
				CircularLL.capacity = Integer.parseInt(input);
			}
			else if(input.matches("A (.*)")){
				int n = Integer.parseInt(input.substring(2));
				while(n>0) {
					input = scanner.nextLine();
					CircularLL.insert(input);
					n--;
				}				
			}
			else if (input.matches("R (.*)")){
				int n = Integer.parseInt(input.substring(2));
				CircularLL.delete(n);
			}
			else if (input.equals("L")) {
				CircularLL.print();
			}
			else if (input.equals("Q")){
				scanner.close();
				System.exit(0);
			}
			else {
				System.out.println("Invalid Input");
			}
		}
	}
}

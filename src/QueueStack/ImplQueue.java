package QueueStack;

import java.util.Scanner;

class LinearQueue<T> {

	T[] queueArray;
	int capacity;
	int front;
	int rear;

	public LinearQueue(int capacity) {
		this.capacity = capacity;
		this.front = -1;
		this.rear = -1;
		queueArray = (T[]) new Object[capacity];
	}

	public void insert(T element) {
		if (this.rear < this.capacity - 1) {
			queueArray[++this.rear] = element;
			if (this.front == -1)
				this.front++;
		} else
			System.out.println("Queue is Full");
	}

	public boolean isEmpty() {
		return (this.rear == -1 || this.front == this.rear + 1);
	}

	public T peek() {
		if (this.rear != -1)
			return queueArray[this.rear];
		return null;
	}

	public T delete() {
		if (!isEmpty())
			return queueArray[this.front++];
		return null;
	}

	public void display() {
		if (!isEmpty()) {
			for (int i = this.front; i <= this.rear; i++)
				System.out.println(queueArray[i]);
		}

	}
}

public class ImplQueue {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		LinearQueue<String> lq = new LinearQueue(Integer.parseInt(scanner
				.nextLine()));
		lq.insert("ABC");
		lq.insert("DEF");
		lq.insert("PQR");
		lq.insert("XYZ");

		lq.display();
		System.out.println();

		System.out.println(lq.peek());

		System.out.println("Deleted" + lq.delete());
		System.out.println("Deleted" + lq.delete());
		System.out.println("Deleted" + lq.delete());
		System.out.println("Deleted" + lq.delete());

		lq.display();
		System.out.println();

		System.out.println(lq.delete());

	}
}

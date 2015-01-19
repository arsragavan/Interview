package heap;

import java.util.ArrayList;

class MaxHeap {

	public ArrayList<Integer> heapify(ArrayList<Integer> a, int i, int n) {

		if (2 * i + 1 >= n)
			return a;

		if ((2 * i + 2 < n) && (a.get(2 * i + 2) > a.get(2 * i + 1))) { // mistake
																		// add
																		// a[2i+2]
																		// >
																		// a[i]
			Integer temp = a.get(2 * i + 2);
			a.set(2 * i + 2, a.get(i));
			a.set(i, temp);
			return (heapify(a, 2 * i + 2, n));
		} else if (a.get(2 * i + 1) > a.get(i)) {
			Integer temp = a.get(2 * i + 1);
			a.set(2 * i + 1, a.get(i));
			a.set(i, temp);
			return (heapify(a, 2 * i + 1, n));
		}
		return a;
	}

	public ArrayList<Integer> heapSort(ArrayList<Integer> a, int n) {
		if (n == 1)
			return a;
		int temp = a.get(0);
		a.set(0, a.get(n - 1));
		a.set(n - 1, temp);
		a = heapify(a, 0, n - 1);
		heapSort(a, n - 1);
		return a;
	}

	public Integer deleteMax(ArrayList<Integer> a, int n) {
		int temp = a.get(0);
		if (n == 1) {
			a = null;
		} else {
			a.set(0, a.get(n - 1));
			a.set(n - 1, temp);
			a.remove(n - 1);
			a = heapify(a, 0, n - 1);
		}
		return temp;
	}

	// If there is no need for deleteMax function it's better to use arrays
	public ArrayList<Integer> minKElements(int[] input, int k, int n) {
		ArrayList<Integer> outputHeap = new ArrayList<>();
		if (n > k) {
			for (int i = 0; i < k; i++)
				outputHeap.add(i, input[i]);

			MaxHeap maxHeap = new MaxHeap();
			for (int i = outputHeap.size() / 2; i >= 0; i--)
				outputHeap = maxHeap.heapify(outputHeap, i, outputHeap.size());
			for (int i = k; i < n; i++) {
				if (outputHeap.get(0) > input[i]) {
					outputHeap.set(0, input[i]);
					outputHeap = maxHeap.heapify(outputHeap, 0,
							outputHeap.size());
				}
			}
		}
		return outputHeap;
	}
}

class MinHeap {

	public ArrayList<Integer> heapify(ArrayList<Integer> a, int i, int n) {

		if (2 * i + 1 >= n)
			return a;

		if ((2 * i + 2 < n) && (a.get(2 * i + 2) < a.get(2 * i + 1))) {
			Integer temp = a.get(2 * i + 2);
			a.set(2 * i + 2, a.get(i));
			a.set(i, temp);
			return (heapify(a, 2 * i + 2, n));
		} else if (a.get(2 * i + 1) < a.get(i)) {
			Integer temp = a.get(2 * i + 1);
			a.set(2 * i + 1, a.get(i));
			a.set(i, temp);
			return (heapify(a, 2 * i + 1, n));
		}
		return a;
	}

	public ArrayList<Integer> heapSort(ArrayList<Integer> a, int n) {
		if (n == 1)
			return a;
		int temp = a.get(0);
		a.set(0, a.get(n - 1));
		a.set(n - 1, temp);
		a = heapify(a, 0, n - 1);
		heapSort(a, n - 1);
		return a;
	}

	public Integer deleteMin(ArrayList<Integer> a, int n) {
		int temp = a.get(0);
		if (n == 1)
			a = null;
		else {
			a.set(0, a.get(n - 1));
			a.set(n - 1, temp);
			a.remove(n - 1);
			a = heapify(a, 0, n - 1);
		}
		return temp;
	}

	public ArrayList<Integer> maxKElements(int[] input, int k, int n) {
		ArrayList<Integer> outputHeap = new ArrayList<>();
		if (n > k) {
			for (int i = 0; i < k; i++) {
				outputHeap.add(i, input[i]);
			}
			MinHeap minHeap = new MinHeap();
			for (int i = outputHeap.size() / 2; i >= 0; i--)
				outputHeap = minHeap.heapify(outputHeap, i, outputHeap.size());
			for (int i = k; i < n; i++) {
				if (outputHeap.get(0) < input[i]) {
					outputHeap.set(0, input[i]);
					outputHeap = minHeap.heapify(outputHeap, 0,
							outputHeap.size());
				}
			}
		}
		return outputHeap;
	}
}

public class Heap {

	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i <= 7; i++)
			a.add(i);
		MaxHeap maxHeap = new MaxHeap();

		for (int i = a.size() / 2; i >= 0; i--)
			a = maxHeap.heapify(a, i, a.size());
		System.out.println(maxHeap.deleteMax(a, a.size()) + " = " + a);

		int[] input = { 1, 3, 5, 7, 9, 10, 8, 6, 4, 2 };
		MaxHeap minHeap = new MaxHeap();
		System.out.println(maxHeap.minKElements(input, 3, input.length));

	}
}

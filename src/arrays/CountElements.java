package arrays;

import java.util.Arrays;

public class CountElements {

	public static void getCount(int[] arr, int n) {

		int pos = 0;
		int desiredPos = 0;
		while (pos < n) {
			if (arr[pos] <= 0) {
				pos++;
			}
			desiredPos = arr[pos] - 1;
			if (arr[desiredPos] > 0) {
				arr[pos] = arr[desiredPos];
				arr[desiredPos] = -1;
			} else {
				arr[desiredPos]--;
				arr[pos] = 0;
				pos++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		int[] arr = { 1, 5, 1, 11, 21, 21, 0, 4, 3, 1 };
		getCount(arr, 10);

	}
}

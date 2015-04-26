package misc;

import java.util.Arrays;

public class EnumPractice {

	public static void main(String[] args) {

		Days days = Days.FRI;
		System.out.println(days.valueOf("SUN"));
		System.out.println(Arrays.toString(Days.values()));
	}
}

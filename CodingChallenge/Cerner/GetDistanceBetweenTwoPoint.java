package cerner;

import java.util.Arrays;

public class GetDistanceBetweenTwoPoint {
	public static void getDistance() {
		String s;

		s = "(25, 4) (1, -6)";
		String[] arr = s.split(",");
		System.out.println(Arrays.toString(arr));
		String[] arr1 = arr[0].split("\\(");
		int x = Integer.valueOf(arr1[1]);
		String[] arr2 = arr[1].split("\\)");

		int y = Integer.valueOf(arr2[0].trim());
		String[] arr3 = arr2[1].split("\\(");

		int x1 = Integer.valueOf(arr3[1]);
		String[] arr4 = arr[2].split("\\)");

		int y1 = Integer.valueOf(arr4[0].trim());
		System.out.println(abstand(x, y, x1, y1));

	}
	
	public static double abstand(int x, int y, int x1, int y1) {
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
	}


}

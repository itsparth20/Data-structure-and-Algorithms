package cerner;

public class Test1 {
	private static void getNbit() {

		String s;
		s = "86,2,3";
		System.out.println(s);
		String[] arr = s.split(",");
		int n = Integer.valueOf(arr[0]);
		int p1 = Integer.valueOf(arr[1]);
		int p2 = Integer.valueOf(arr[2]);
		String s2 = Integer.toBinaryString(n);
		if (p1 < s2.length() && p2 < s2.length()) {
			if (s2.charAt(s2.length() - p1) == '1' && s2.charAt(s2.length() - p2) == '1') {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		} else {
			System.out.println("False");
		}

	}

}

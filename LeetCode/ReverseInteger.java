package practiceProblem.leetcode;
/*
 * 7. Reverse Integer
 * 
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

More Description: https://leetcode.com/problems/reverse-integer/#/description
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483648));
	}

	public static int reverse(int x) {
		StringBuilder sb;
		String y;
		if (x < 0) {
			long p1 = x;
			long p = Math.abs(p1);
			y = String.valueOf(p);			
		} else 
			y = String.valueOf(x);		
		sb = new StringBuilder(y);
		long xl = Long.parseLong(sb.reverse().toString());
		if (xl > Integer.MAX_VALUE)
			return 0;
		else {
			if (x < 0)
				xl = -xl;			
			return (int) xl;
		}
	}

}

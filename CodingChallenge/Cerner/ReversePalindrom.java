package cerner;

public class ReversePalindrom {

	public static void main(String[] args) {
		System.out.println(getPalindrom(7325));
	}

	public static Integer getPalindrom(int number) {
		while (true) {
			int reverseNumber = getReverse(number);
			number += reverseNumber;
			if (number == getReverse(number))
				return number;
		}
	}

	public static Integer getReverse(int number) {
		int reverse = 0;
		int rem =0;
		while (number != 0) {
			rem = number % 10;
			number = number / 10;
			reverse = (reverse * 10) + rem;
		}
		return reverse;
	}

}

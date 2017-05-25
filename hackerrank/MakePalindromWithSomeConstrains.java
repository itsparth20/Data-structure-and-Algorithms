package hackerrank;
/*
 * The Love-Letter Mystery
 * 
 * James found a love letter his friend Harry has written for his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.
 * 
 * To do this, he follows two rules:
 * 
 * He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
 * In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.
 * 
 * Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
 * 
 * Sample Input
 * abc
 * abba
 * abcd
 * 
 * Output
 * 2
 * 0
 * 4
 */
import java.util.Scanner;

public class MakePalindromWithSomeConstrains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int chance = sc.nextInt();
		for (int i = 0; i < chance; i++) {
			String s = sc.nextLine();
			countChanges(s);
		}

		countChanges("cba");
	}

	public static void countChanges(String s) {
		int changes = 0;
		int i = 0;
		while (i < s.length() / 2) {
			if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
				i++;
				continue;
			}

			int big = s.charAt(i) > s.charAt(s.length() - i - 1) ? s.charAt(i) - s.charAt(s.length() - i - 1)
					: s.charAt(s.length() - i - 1) - s.charAt(i);
			changes += big;
			i++;
		}

		System.out.println(changes);
	}

}

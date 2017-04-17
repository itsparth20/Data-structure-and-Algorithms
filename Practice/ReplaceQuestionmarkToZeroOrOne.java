package practiceProblem;

import java.util.Arrays;

//Input : 1??0?10
//Output : replace ? to 0 or 1. Display all the combination that we can create using 0 and 1;

public class ReplaceQuestionmarkToZeroOrOne {
	public static void main(String[] args) {
		String s = "1??0?10";
		generateBinary(s.toCharArray(), s.length(), 0, s.toCharArray());
	}

	private static void generateBinary(char[] s, int length, int i, char[] s2) {
		if (length == i) {
			System.out.println(Arrays.toString(s2));
			return;
		}
		if (s[i] == '?') {
			s2[i] = '0';
			generateBinary(s, length, i + 1, s2);
			s2[i] = '1';
			generateBinary(s, length, i + 1, s2);
		} else {
			generateBinary(s, length, i + 1, s2);
		}
	}
}

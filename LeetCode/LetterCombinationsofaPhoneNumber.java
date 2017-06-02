package practiceProblem.leetcode;
/*
 * 17. Letter Combinations of a Phone Number
 * 
 * More Description: https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


 */
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("23"));
	}

	public static String[] digitsArr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public static List<String> list;
	
	//23

	public static List<String> letterCombinations(String digits) {
		list = new ArrayList<String>();
		if (digits.length() == 0)
			return list;
		helper(digits, "", 0);
		return list;
	}

	public static void helper(String digits, String output, int digitIndex) {
		if (output.length() == digits.length()) {
			list.add(output);
		}
		if(output.length() < digits.length()) {
			for (int i = digitIndex; i < digits.length(); i++) {
				for (int j = 0; j < digitsArr[digits.charAt(i) - '0'].length(); j++) {
					helper(digits, output + digitsArr[ digits.charAt(i) - '0' ].charAt(j), i+1);
				}
			}
		}
	}

}

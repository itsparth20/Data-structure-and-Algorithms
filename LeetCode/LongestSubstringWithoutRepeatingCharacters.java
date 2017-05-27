package practiceProblem.leetcode;
/*
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * 
 Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

More description : https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 */
import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int size = 0;
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			while (list.contains(s.charAt(i)) && list.size() > 0 ) {
				list.remove(0);
			}
			list.add(s.charAt(i));
			size = size > list.size() ? size : list.size();

		}
		return size;
	}

}

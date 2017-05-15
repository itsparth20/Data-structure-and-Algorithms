package practiceProblem.leetcode;

/*
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
 */
public class DeleteOperationforTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "sea";
		String word2 = "eat";
		DeleteOperationforTwoStrings o = new DeleteOperationforTwoStrings();
		System.out.println(o.minDistance(word1, word2));
	}

	public int minDistance(String word1, String word2) {
		
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for(int i = 1; i <= word1.length(); i++){
			for(int j = 1; j <= word2.length(); j++){
				dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] +1 : Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
	}

}

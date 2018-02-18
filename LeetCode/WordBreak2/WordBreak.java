/*
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/description/
 */

package practice.wordBreak;

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
	}
	
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> lst = new ArrayList<>();
        helper(s, wordDict, lst);
        return result;
    }
    
    public void helper(String s, List<String> wordDict, List<String> lst){
        if(s.equals("")){
            return;
        }
        for(int i = 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                lst.add(s.substring(0,i));
                helper(s.substring(i), wordDict, lst);
                if(i == s.length()){
                    result.add(String.join(" ", lst));
                }
                lst.remove(lst.size()-1);
            }
        }
    }
}
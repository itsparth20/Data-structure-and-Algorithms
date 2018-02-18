/*
https://leetcode.com/problems/word-break/description/
139. Word Break
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] b = new boolean[s.length()+1];
        b[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(b[j] && set.contains(s.substring(j,i))){
                    b[i]= true;
                }
            }
        }
        return b[s.length()];        
    }
}
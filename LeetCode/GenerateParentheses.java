/*
22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/description/
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        getAllCombination(list, n, "", 0, 0);
        return list;
        
    }
    
    public void getAllCombination(List<String> list, int n, String s, int start, int end){
        if(s.length() == n*2){
            list.add(s);
            return;
        }
        
        if(start < n)
            getAllCombination(list, n, s+"(", start+1, end);
        if(end < start)
            getAllCombination(list, n, s+")", start, end+1);
    }
}
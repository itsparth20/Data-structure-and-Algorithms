//131. Palindrome Partitioning
//https://leetcode.com/problems/palindrome-partitioning/description/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<>();
        helper(list, temp, s, 0);
        return list;
    }
    
    public void helper(List<List<String>> list, List<String> temp, String s, int k){
        if(k == s.length()){
            list.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = k+1; i <= s.length(); i++){
             if(palindrom(s.substring(k,i))){
                 temp.add(s.substring(k,i));
                 helper(list, temp, s, i);
                 temp.remove(temp.size()-1);
             }
        }
    }
    private boolean palindrom(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
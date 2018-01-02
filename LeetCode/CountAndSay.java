/*
https://leetcode.com/problems/count-and-say/description/
38. Count and Say
http://www.careercup.com/question?id=4425679
*/
class Solution {
    public String countAndSay(int n) {
        String s = String.valueOf(n);
        
        String out = "1";
        for(int i = 2; i <= n; i++){
            out = getString(out);
        }
        return out;
    }
    public String getString(String s){
        StringBuilder sb = new StringBuilder();
        s = s + s.charAt(s.length()-1);
        int count = 0;
        int i = 0;
        for(i =1; i < s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)) count++;
            else {
                sb.append((++count));
                sb.append((s.charAt(i-1)));
                count = 0;
            }
        }
        sb.append((count));
        sb.append((s.charAt(i-1)));
        return sb.toString();
    }
}
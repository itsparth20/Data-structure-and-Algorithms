/*
https://leetcode.com/problems/wildcard-matching/description/
44. Wildcard Matching
*/
class Solution {
    public boolean isMatch(String s, String p) {
        char[] pattern = p.toCharArray();
        char[] string = s.toCharArray();
        
        //remove extra * like a**b then make it like a*b
        boolean found = false;
        int index = 0;
        for(int i =0; i < pattern.length; i++){
            if(pattern[i] == '*'){
                if(!found){
                    found = true;
                    pattern[index++] = pattern[i];
                }                
            }
            else{
                found = false;
                pattern[index++] = pattern[i];
            }
        }
        
        // for(int i = 0; i < index; i++){
        //     System.out.println(pattern[i]);
        // }
        
        //now our pattern in proper format
        
        boolean[][] arr = new boolean[string.length + 1][index + 1];
        
        if(index > 0 && pattern[0] == '*'){
            arr[0][1] = true;            
        }
        arr[0][0] = true;
        for(int i = 1; i <= string.length; i++){
            for(int j = 1; j <= index; j++){
                if(pattern[j-1] == string[i-1] || pattern[j-1] == '?'){
                    arr[i][j] = arr[i-1][j-1];
                }
                else if (pattern[j-1] == '*'){
                    arr[i][j] = arr[i-1][j] || arr[i][j-1]; 
                }
            }
        }
        
        
        
        // for(int i = 0; i <= string.length; i++){
        //     for(int j = 0; j <= index; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return arr[string.length][index];
    }
}
/*
11. Container With Most Water

https://leetcode.com/problems/container-with-most-water/

Given n non-negative integers a1, a2, ..., an , 
where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two 
endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms 
a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

*/

class Solution {
//     public int maxArea(int[] height) {
        
//         int max = Integer.MIN_VALUE;
//         int min = 0;
//         for (int i = 0; i < height.length; i++){
//             for(int j = i+1; j < height.length; j++){
//                 min = Math.min(height[i], height[j]);
//                 max = Math.max(max, (j-i)*min);
//             }
//         }
//         return max;
//     }
    
    public int maxArea(int[] height) {
        int max = 0, vol=0;
        int i=0;
        int j = height.length-1;
        while(i!=j){
            vol = Math.min(height[i], height[j]) * (j-i);
            max = (vol > max) ? vol : max;
            if(height[i]>height[j]) j--;
            else i++;
        }
        return max;
    }
}
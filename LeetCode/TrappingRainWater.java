/*
https://leetcode.com/problems/trapping-rain-water/description/
42. Trapping Rain Water
*/
class Solution {
    public int trap(int[] height) {
        int maxL = 0, maxR = 0,n = height.length, water = 0;
        
        int[] leftMax = new int[height.length];
        int[] rigthMax = new int[height.length];
        
        for(int i = 0, j = n-1; i < n; i++, j--){
            leftMax[i] = maxL;
            if(maxL < height[i]) maxL = height[i];
            rigthMax[j] = maxR;
            if(maxR < height[j]) maxR = height[j];
        }
        
        for(int i = 0; i < n; i++){
            int w = Math.min(leftMax[i], rigthMax[i]) - height[i];
            if(w > 0) water += w; 
        }
        return water;
    }
}
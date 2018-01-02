/*
https://leetcode.com/problems/remove-element/description/
27. Remove Element
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int match = 0, start = 0, last = nums.length -1;
        
        while(last >= start){
            if (nums[last] != val){
                while(start < last && nums[start] != val) start++;
                if(start < last && nums[start] == val) {
                    nums[start] = nums[last];
                    match++;
                }
            }
            else
                match++;
            last--;
        }
        return nums.length-match;
        
    }
}
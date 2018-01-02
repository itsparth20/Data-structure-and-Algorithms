/*
https://leetcode.com/problems/search-insert-position/description/
35. Search Insert Position
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0;
        
        while(left <= right){
            mid = (left+right)/2;;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return nums[mid] < target ? mid+1 : mid;
    }
}
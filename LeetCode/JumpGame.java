/*
55. Jump Game
https://leetcode.com/problems/jump-game/description/
*/
class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }
    
    public boolean helper(int[] nums, int j){
        if(j >= nums.length-1){
            return true;
        }
        for(int i = nums[j]; i > 0; i--){
            if(helper(nums, i+j)){
                return true;
            }
        }
        return false;
    }
    
    /*
    O(N) solution by check each index max reachable
    public boolean canJump(int[] nums) {
    int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
    return true;
    }
    */
}
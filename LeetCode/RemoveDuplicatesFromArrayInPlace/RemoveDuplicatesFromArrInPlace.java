class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int len = 1;
        int c = 0;
        for (int i = 1; i < nums.length; i++){
            if(nums[c] != nums[i]){
                len++;
                c++;
                nums[c] = nums[i];
            }
        }
        return len;
    }
}
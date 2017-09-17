package leetcode.outco;

public class SortColor {
	
}

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int[] count = new int[3];
        for(int i = 0 ; i < len; i++){
            count[nums[i]]++;            
        }        
        int position = 0;
        for(int i = 0; i < count[0]; i++){
            nums[position] = 0;
            position++;
        }
        for(int i = 0; i < count[1]; i++){
            nums[position] = 1;
            position++;
        }
        for(int i = 0; i < count[2]; i++){
            nums[position] = 2;
            position++;
        }
        
    }
}

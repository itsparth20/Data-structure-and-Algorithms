/*
88. Merge Sorted Array
https://leetcode.com/submissions/detail/136081992/
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n -1;
        int nums1Last = m - 1;
        int nums2Last = n - 1;
        while(nums1Last >=0 && nums2Last >= 0){
            if(nums1[nums1Last] > nums2[nums2Last]){
                nums1[last] = nums1[nums1Last];
                nums1Last--;
            }else{
                nums1[last] = nums2[nums2Last];
                nums2Last--;
            }
            last--;
        }
        for(int i = nums2Last; i >= 0; i--){
            nums1[last] = nums2[i];
            last--;
        }
    }
}
/*
https://leetcode.com/problems/median-of-two-sorted-arrays/description/
4. Median of Two Sorted Arrays
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length, start = 0, end = nums1.length, mid = 0;
        
        while(start <= end){
            mid = ( start + end ) / 2;
            int partion = (n + m + 1)/2 - mid;
            
            int maxleftx = (mid==0) ? Integer.MIN_VALUE : nums1[mid-1];
            int minrightx = (mid == n) ? Integer.MAX_VALUE : nums1[mid];
            
            int maxlefty = (partion == 0) ? Integer.MIN_VALUE : nums2[partion-1];
            int minrighty = (partion == m) ? Integer.MAX_VALUE : nums2[partion];
            
            if(maxleftx <= minrighty && maxlefty <= minrightx){
                if((m+n)%2 != 0){
                    return (double)(Math.max(maxleftx, maxlefty));
                }else{
                    return ((double) Math.max(maxleftx, maxlefty) + Math.min(minrightx, minrighty) )/2;
                }
            }else if(maxleftx > minrighty) end = mid -1;
            else start = mid + 1;
        }   
        return -1.0;
    }
}
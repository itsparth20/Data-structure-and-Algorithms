/*
152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/description/
*/
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length < 2) return nums[0];
        int max = nums[0];
        int mul = 0;
        for(int i = 0; i < nums.length-1; i++){
            mul = nums[i];
            for(int j = i+1; j < nums.length; j++){
                max = Math.max(mul, max);
                mul *= nums[j];                
            }
            max = Math.max(mul, max);
        }
        return Math.max(max, nums[nums.length-1]);
    }
}

/*
Time complexity: O(N)
Space complexity: O(1)
public class test {
    static int A[] = {2, 3, -2, 4, -1, 49};
    public static void main(String[] args) {
        int r = A[0];
        for(int i = 1, imax = r, imin = r; i < A.length; i++){
            if (A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(A[i], A[i] * imax);
            imin = Math.min(A[i], A[i] * imin);
            r = Math.max(r, imax);
        }
        System.out.println(r);
    }
}

*/
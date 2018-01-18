/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
108. Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(0, nums.length-1, nums);
        // return root;
    }
    public TreeNode helper(int l, int r, int[] nums){
        if(l>r) return null;
        if(l == r) return new TreeNode(nums[l]);
        int mid = (l+r)/2;
        TreeNode data = new TreeNode(nums[mid]);
        data.left = helper(l, mid -1, nums);
        data.right = helper(mid+1, r, nums);
        return data;
    }
}
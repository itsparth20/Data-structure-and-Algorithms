
/*
66. Plus One
Description: https://leetcode.com/problems/plus-one/#/description
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length > 0){
            int i = digits.length-1;
            while( i >= 0 ){
                if(digits[i] >= 0 && digits[i] <= 8 ){
                    digits[i] += 1;
                    return digits;
                }else{
                    digits[i] = 0;
                }
                i--;
            }
            int arr[] = new int[digits.length+1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
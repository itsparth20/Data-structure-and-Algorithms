/*
Description: https://leetcode.com/problems/integer-to-roman/#/description

12. Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

M = 1000, D = 500, C = 100, L = 50, X = 10, V = 5, I = 1

Example
Input: 9     	=>	Output: ‘IX’
Input: 8     	=>	Output: ‘VIII’
Input: 49     	=>	Output: ‘XLIX’ 	

*/

class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",  "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num > 0){
            while(values[i] <= num){
                num -= values[i];
                sb.append(roman[i]);
            }
            i++;
        }
        return sb.toString();
    }    
}
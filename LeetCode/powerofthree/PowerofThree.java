package com.leetcode.powerofthree;

/*
326. Power of Three
https://leetcode.com/problems/power-of-three/description/
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;

        while(n % 3 == 0){
            n = n / 3;
        }
        if(n == 1) return true;
        return false;

    }
}

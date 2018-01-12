/*
70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/description/
*/
class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int x = 1;
        int y = 2;
        int result = 0;
        for(int i = 2; i < n; i++){
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }
	/*
	public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
           a = (b += a) - a;
        return a;
    }
	*/
}
/*
69. Sqrt(x)
https://leetcode.com/problems/sqrtx/description/
*/
class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(mid > x/mid) right = mid - 1;
            else{
                if(mid + 1 > x/(mid+1)) return mid;
                left = mid +1;
            }
        }
        return mid;
    }
}

/*
Another solution
	public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
*/
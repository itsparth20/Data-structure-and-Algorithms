/*
https://leetcode.com/problems/powx-n/description/
50. Pow(x, n)
*/
class Solution {
    public double myPow(double x, int n) {
        double a = pow(x, Math.abs(n));
        if(n < 0){
            return 1/a;
        }
        return a;
            
    }
    public double pow(double x, int n){
        if(n == 0) return 1;
        if(n%2 == 0) {
            double y = pow(x,n/2);
            return y * y;
        }
        return x * pow(x,n-1);
    }
}

/*
class Solution {
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
};
*/

/*
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
*/
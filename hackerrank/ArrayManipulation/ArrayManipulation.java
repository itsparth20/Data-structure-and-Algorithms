//https://www.hackerrank.com/challenges/crush/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long max = 0;
        long[] arr = new long[n];
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            arr[a-1] += k;
            if(b < n) arr[b] -= k;
        }
        long x = 0;
        for(int i = 0; i < n; i++){
            x += arr[i];
            max = x > max ? x : max;
        }
        System.out.println(max);
        in.close();
    }
}

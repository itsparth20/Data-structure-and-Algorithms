// https://www.hackerrank.com/challenges/reverse-game/copy-from/27175508


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i = 0; i< testcase; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] data = new int[n];
            int x= 0, y=n;
            for(int j = 0; j<n; j++){
                if(j==0){
                    data[j] = --y;

                }
                else if(j%2!=0){
                    data[j] = x++;
                }
                else{
                    data[j] = --y;
                }
                if(data[j] == k){
                        System.out.println(j);
                        break;
                    }
            }
        }
    }
}
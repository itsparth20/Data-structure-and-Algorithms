/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author itspa
 */
public class EvenFibonacciNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum = 0;
            long i = 2;
            long j = 8;
            long k = 0;
            while(k<=n){
                sum +=j;
                k = 4*j+i;
                i=j;
                j=k;
                
            }
            System.out.println(sum+2);
        }
    }
}

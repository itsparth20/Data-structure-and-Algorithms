/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author itspa
 */
public class Multiplesof3and5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inputFirst = sc.nextLong();
        for(long i=0;i<inputFirst;i++){
            long number = sc.nextLong();
            long a=0, b=0, d=0;
            a=(number-1)/3;
            b=(number-1)/5;
            d=(number-1)/15;            
            long c= 3*a*(a+1)/2 + 5*b*(b+1)/2 - 15*d*(d+1)/2;
            System.out.println(c);
        }
    }
}

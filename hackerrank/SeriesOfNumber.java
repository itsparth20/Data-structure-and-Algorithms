
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */
public class SeriesOfNumber {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long max = 10^18;
        
        for(long i=0; i<x; i++){
            long temp = sc.nextLong();
            temp = temp % 1000000007; 
            long sum = temp*temp;
            
            sum = sum%1000000007;
            //long temp1=(long)sum;
            System.out.println(sum);
        }
    }
}

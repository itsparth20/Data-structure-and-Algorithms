
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
public class DiwaliProblem {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int value = sc.nextInt();
        for(int i =0; i<value; i++){
            long temp = sc.nextLong();
            long val = 1;
            for (long j = 0; j < temp; j++) {
                val *= 2;
                val = val % 100000;
            }
            System.out.println(val-1);
        }
    }
}

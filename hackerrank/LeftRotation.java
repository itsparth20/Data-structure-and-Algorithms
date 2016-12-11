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
public class LeftRotation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[(i+n-d)%n] = sc.nextInt();
        }
        
       for(int i =0; i<n;i++){
           System.out.print(arr[i] + " ");
       }
        
       
    }
}

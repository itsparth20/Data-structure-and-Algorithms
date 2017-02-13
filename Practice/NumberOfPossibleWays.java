/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navisens;

/**
 *
 * @author itspa
 */
public class NumberOfPossibleWays {
    public static void main(String[] args){
        System.out.println(numberOfWays(610));
    }

    private static int numberOfWays(int n) {
        int[] arr = new int[n+1];
        int j = 0;
        
        arr[0] = 1;
        
        for(int i = 1; i<=n; i++){
            arr[i] += arr[i-1];
        }
        for(int i = 2; i<=n; i++){
            arr[i] += arr[i-2];
        }
        for(int i = 3; i<=n; i++){
            arr[i] += arr[i-3];
        }
        for(int i = 4; i<=n; i++){
            arr[i] += arr[i-4];
        }
        for(int i = 5; i<=n; i++){
            arr[i] += arr[i-5];
        }
        for(int i = 6; i<=n; i++){
            arr[i] += arr[i-6];
        }
        return arr[n];
    }
}

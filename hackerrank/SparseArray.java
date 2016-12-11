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
public class SparseArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.next();
        }
        int q = sc.nextInt();
        int ct = 0;
        for(int i = 0; i<q;i++){
            String query = sc.next();
            for(int j=0;j<n;j++){
                if(query.equals(arr[j])){
                    ct++;
                }
            }
            System.out.println(ct);
            ct=0;
        }
    }
}

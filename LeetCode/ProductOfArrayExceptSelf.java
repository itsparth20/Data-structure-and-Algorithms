/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class ProductOfArrayExceptSelf {
    public int[] pr(int a[], int N){
        
        int[] products = new int[N];

        // Get the products below the current index
        int p=1;
        for(int i=0;i<N;++i) {
          products[i]=p;
          p*=a[i];
        }

        // Get the products above the curent index
        p=1;
        for(int i=N-1;i>=0;--i) {
          products[i]*=p;
          p*=a[i];
        }
        return products;
    }
    
    public static void main(String args[]){
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] a = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(obj.pr(a, a.length)));
    }
}

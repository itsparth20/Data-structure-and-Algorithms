/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashSet;

/**
 *
 * @author itspa
 */
public class PairsUsingHashSet {
    public static int pairs(int[] a,int k) {
      /* Complete this function */
        int count = 0;
        //for(int i =0; i<a.length-1; i++){
            //for(int j = i+1; j<a.length; j++){
              //  int temp = a[i] - a[j];
            //    if(Math.abs((long)temp) == k) count++;
          //  }
        //}
        HashSet<Integer> ab = new HashSet<Integer>();
        for(int i =0; i<a.length; i++){
            ab.add(a[i]);
        }
        for(int i =0; i<a.length; i++){
            if(ab.contains(a[i]+k)) count++;
        }
        return count;
    }
    
    public static void main(String[] args){
        PairsUsingHashSet obj = new PairsUsingHashSet();
        int[] a = {1,3,2,4};
        int b = 2;
        System.out.println(obj.pairs(a, b));
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.HashSet;

/**
 *
 * @author itspa
 */
public class CheckDuplicatesWithinK {
    public static void main(String[] args){
        int[] a = {1,2,3,1,2,3,4,5,6};
        int k = 2;
        System.out.println(checkInt(a,k));
        
    }
    public static boolean checkInt(int[] a, int k){
        
        HashSet<Integer> h = new HashSet<>();
        
        for(int i = 0; i<a.length; i++){
            if(h.contains(a[i]))
                return true;
            
            h.add(a[i]);
            
            if(i>=k)
                h.remove(a[i-k]);
        }
        return false;
    }
}

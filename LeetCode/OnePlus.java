/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */
public class OnePlus {
    public static void main(String[] args){
        int a[] = {9,9,9};
        int b[] = addOne(a).clone();
    }

    private static int[] addOne(int[] a) {
        int len = a.length;
        for(int i = len-1; i>=0; i--){
            if(a[i] < 9){
                a[i]++;
                return a;
            }else{
                a[i] = 0;
            }
        
        }
        a = new int[len+1];
        a[0] = 1;
        return a;
    }
}

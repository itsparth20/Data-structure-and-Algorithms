/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlindData;

/**
 *
 * @author itspa
 */
public class Question1 {
    public static void main(String[] args){
        System.out.println(f(18));
    }

    private static int f(int n) {
        int[] primes = {2,3,5,7,11,13,17,19};
        int size = primes.length;
        int retval = 0;
        
        for(int i=0;i<n;i++){
            if(i % 2 == 0 || is_in_array(primes, size, i)){
                continue;
            }
            retval+=i;
        }
        return retval;
    }

    private static boolean is_in_array(int[] primes, int size, int element) {
        for(int i=0; i< size; i++){
            if(primes[i] == element){
                return true;
            }
        }
        return false;
    }
}

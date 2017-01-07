/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlindData;

import java.util.Random;

/**
 *
 * @author itspa
 */
public class Question7 {
    public static void main(String[] args){
        Random rand = new Random();
        
        int[] arr = new int[1000];
        for(int i =0; i<1000; i++){
            arr[i] = rand.nextInt(1000);
        }
        int c = 0;
        for(int j = 0; j < 1000; j++){
            for(int k = j; k < 999; k++){
                c++;
                
            }
        }
        System.out.println(c);
    }
}

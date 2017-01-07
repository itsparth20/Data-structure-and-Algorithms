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
public class Question5 {
    public static void main(String[] args){
        func(5);
    }

    private static void func(int length) {
        int[] arr = new int[++length];
        
        for(int i =0; i< length; i++){
            arr[i] = 3*i;
        }
        for(int i=0; i<length; i++){
            System.out.println(arr[i]);
        }
    }
}

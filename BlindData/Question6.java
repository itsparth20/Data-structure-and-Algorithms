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
public class Question6 {
    public static void main(String[] args){
        fizzbuzz(2);
        System.out.print(" - ");
        fizzbuzz(75);
        System.out.print(" - ");
        fizzbuzz(35);
        System.out.print(" - ");
        fizzbuzz(29);
        System.out.print(" - ");
        fizzbuzz(27);
        System.out.println("");
    }
    

    private static void fizzbuzz(int x) {
       if(x % 3 ==0){
           System.out.print("fizz");
       }
       if(x % 5 ==0){
           System.out.print("buzz");
       }
       if((x%3!=0 ) && (x%5!=0)){
           System.out.print(x);
       }
    }
}

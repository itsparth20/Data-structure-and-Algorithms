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
public class Question8 {
    public static void main(String[] args){ 
        int a = 0b100110;
        int b = 0b010001;
        int c = 0b001001;
        System.out.println(a&b);  
        System.out.println(a|b);  
        System.out.println(b^c);
        System.out.println(a&(b^c));
        
        System.out.println("result:");
        
        if( (a&b)!=0){
            System.out.print(" One");
        }
        if( (a|b) > 32){
            System.out.print(" two");
        }
        if( (a & (b ^ c)) == 0){
            System.out.print(" three");
        }
        System.out.println("");
    }
}

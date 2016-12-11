
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */
public class Synative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        System.out.println(data);
        
       char[] input = data.toCharArray();
        
        
        System.out.println(checkpalindrom(input));
        String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.substring(0) );

      System.out.print("Return Value :" );
      System.out.println(Str.substring(10, 15) );

      //  System.out.println(checkpl(data));
    }

    private static String checkpalindrom(char[] input) {
        int i = 0;
        int j = input.length -1;
        while(j>=i){
            if(input[i]!=input[j])
                return "Not Palindrom";
            if(i==j){
                char value = input[i];

                int nextValue = (int)value + 1; // find the int value plus 1
                if(nextValue == 58)
                    nextValue = 48;
                
                char c = (char)nextValue; // convert that to back to a char
                
                input[i] = c;
               // System.out.println(c);
            }
            ++i; 
            --j;
            
        }
        //System.out.println(Arrays.toString(input));
        return Arrays.toString(input);
    }

    private static boolean checkpl(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}

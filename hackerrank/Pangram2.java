/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;
import java.util.Scanner;

/**
 *
 * @author itspa
 */
public class Pangram2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            Scanner in=new Scanner(System.in);
            String str=in.nextLine();
            str=str.toLowerCase();
            String isPanagram="panram";
            if(str.length()<26){
               // isPanagram=false;
                System.out.println("not pangram");
            }else {
                int[] allLetters = new int[26];
                for (int i = 0; i < allLetters.length; i++) {
                    allLetters[i] = 0;
                }
                for (int i = 0; i < str.length(); i++) {
                    if((int) str.charAt(i) - 97 <=0 && (int) str.charAt(i) - 97 >=26){
                    if((int)str.charAt(i)!=32) {
                        allLetters[(int) str.charAt(i) - 97] += 1;
                    }
                }}
                int c = 1;
                for (int i = 0; i < allLetters.length; i++) {
                    if (allLetters[i] == 0) {
                        isPanagram = "not pangram";
                        System.out.println("not pangram");
                        c = 0;
                        break;
                    }
                    else{
                        if(c < allLetters[i]){
                            c = allLetters[i];
                        }
                    }
                }
                int temp =0;
                if(c == 1){
                    System.out.println("pangram");
                    temp = 1;
                }
                
                else if(c!=0){
                    for (int i = 0; i < allLetters.length; i++) {
                        if (allLetters[i] != c) {
                            System.out.println("pangram");
                            temp =1;
                            break;
                        }
                    }
                    
                }
                if(temp ==0 && c!=0)
                {
                    System.out.println("multiple pangram " + c);
                }
            }
            
    }
}

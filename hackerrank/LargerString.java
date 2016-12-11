
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
public class LargerString {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        
        System.out.println(rearrangeWord(word));
        
    }
    
    static String rearrangeWord(String word) {
        char[] ch = word.toCharArray();
        char[] chdup = word.toCharArray();
        int len = ch.length;
        int match =1;
        String text1 = "";
        if(len < 2 || len > 10000){
            return "no answer";
        }
        
        char check = ch[0];
        for(int i =1; i< len; i++){
            if(ch[i] == check){
                match++;
            }
        }

        if(match == len){
            return "no answer";
        }
        
        check = ch[len-1];
        for(int i =len-2; i>=0; i--){
            if(check > ch[i]){
                char temp = ch[i];
                ch[i] = check;
                ch[len-1] = temp;
                text1 = String.valueOf(ch);
                return text1;
            }
        }
        
        
        Arrays.sort(chdup);
        boolean eq=Arrays.equals(ch, chdup);
        if(eq)
            return "no answer";
        
        check = ch[len-1];
        for(int i =len-2; i>=0; i--){
            if(check < ch[i]){
                char temp = ch[i];
                ch[i] = check;
                ch[len-1] = temp;
                text1 = String.valueOf(ch);
                return text1;
            }
        }
        
            
        return "no answer";
    }
}

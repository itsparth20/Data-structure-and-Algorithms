/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itspa
 * input: abc;
 * output: zyx
 * 
 * input: def
 * output: wvu
 * 
 * Note: Only a-z reflect. 
 * 
 */
public class DecodeString {
     public static void main(String[] args){
         int i = 'a';
         int j = 219-i;
         int arr[] = {3, 1, 4, 1};
//         System.out.println(answer(arr));
         
         System.out.println(answer("wrw blf hvv ozhg mrtsg'h vkrhlwv?"));
         System.out.println(answer("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));
         
     }
     
     
      public static String answer(String s) { 
    
        // Your code goes here.
        StringBuffer sb = new StringBuffer();         
         for(int i = 0; i<s.length(); i++){
             int chAscii = s.charAt(i);
             if(chAscii >= 97 && chAscii <= 122){
                 int ascii = 219-chAscii;
                 sb.append((char)ascii);
             }else{
                 sb.append(s.charAt(i));
             }
         }                 
        return sb.toString();
    } 
}

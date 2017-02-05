
/*
* Homework II                               
*                                                                   
* Prompt:   Given a set S, return the power set P(S), which is        
*           a set of all subsets of S.                                
*                                                                   
* Input:    A String                                                  
* Output:   An Array of Strings representing the power set of the input
*                                                                   
* Example:  S = "abc", P(S) = ['', 'a', 'b','c','ab','ac','bc','abc']
                                [d, ad, bd, cd, abd, acd, bcd, abcd]
*                                                                   
* Note:     The input string will not contain duplicate characters
*           The letters in the subset string must be in the same order
*           as the original input.
*/


import java.util.*;
import java.util.ArrayList;

public class recursion {
  public static void main(String[] args) {
    System.out.println(PowerSet.compute("abcd"));
    
  }
}
class PowerSet{
  // your work here
  private static List<String> results; 
  private static String input;
  private static char[] charArr;
  private static int n;
  public static List<String> compute(String str) {  
      results = new ArrayList<String>();
      
   input = str;
   n = input.length();
   int bitArr[] = new int[n];
   charArr = str.toCharArray();
      
   traverse(bitArr, 0);
   return results;
  }
  
  private static void traverse(int[] bitArr, int k) {
      if(k==n-1){
          bitArr[k] = 0;
          print(bitArr);
          bitArr[k] = 1;
          print(bitArr);
          return;
      }
      bitArr[k] = 0;
      traverse(bitArr, k+1);
      bitArr[k] = 1;
      traverse(bitArr, k+1);
  }

    private static void print(int[] bitArr) {
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        for(int i =0; i<n; i++){
            if(bitArr[i] == 1){
                sb.append(input.charAt(i));
                sum++;
            }
        }
        if(sum == 0){
            sb.append("null");
        }
        results.add(sb.toString());
    }
}

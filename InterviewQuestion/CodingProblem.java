/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author itspa
 */

/*
Hackrank Challenge: 
// we can count formate like 01, 10, 0011, 1100, 000111, 111000
//consicutive number of 0's and 1's.
// find the number of substring occure in this formate 

input =0011 
output = 2 // 01, 0011

input = 01
output = 1

input = 01010
output = 4 //01, 10, 01, 10

input = 01100
output = 3 // 01, 10, 1100

input = 0011001000001111
output = 10
*/
public class CodingProblem {
    public static void main(String[] args){
    System.out.println(counting("01010"));
    
    }
    
    public static int counting(String s) {
        int count = 0;
        int zeros = 0;
        int ones = 0;
        boolean comeAfterOne = false;
        boolean comeAfterZeros = false;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                
                if(comeAfterOne == true){
                    zeros=0;
                    comeAfterOne = false;
                }
                zeros++;
                if(ones > 0){
                    ones--;
                    count++;
                }                
            }
            if(s.charAt(i)=='1'){
                
                if(comeAfterZeros == true){
                    ones=0;
                    comeAfterZeros = false;
                }
                ones++;
                if(zeros>0){
                    zeros--;
                    count++;
                }
            }
        }
        return count;

    }


}


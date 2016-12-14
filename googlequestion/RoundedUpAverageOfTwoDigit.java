/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class RoundedUpAverageOfTwoDigit {
    public static void main(String[] args){
        int a = 623315;
        RoundedUpAverageOfTwoDigit obj = new RoundedUpAverageOfTwoDigit();
        System.out.println(obj.max(a));
    }
    public int max(int num){
        String numStr = Integer.toString(num);
        if(numStr.length() == 1){
            return num;
        }
        char[] n = numStr .toCharArray();
        int count = 0;
        int[] maxArr = new int[n.length-1];
        for(int i=1; i<n.length; i++){
            double a = Character.getNumericValue(n[i-1]);
            double b = Character.getNumericValue(n[i]);
            int value = (int) Math.round((a+b)/2);
            String val = Integer.toString(value);
            String vall;
            if(i == 1){
                vall = val + numStr.substring(i+1);
            }
            else{    
                vall = numStr.substring(0,i-1) + val + numStr.substring(i+1);
            }
            maxArr[count++] = Integer.parseInt(vall);
        }
        Arrays.sort(maxArr);
        return maxArr[--count];
//        if(num == null){
//            
//        }
        
    }
}

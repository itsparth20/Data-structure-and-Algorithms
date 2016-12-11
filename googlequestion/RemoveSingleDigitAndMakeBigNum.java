/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.Scanner;

/**
 *
 * @author itspa
 */
public class RemoveSingleDigitAndMakeBigNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = 0;
        String strNum = sc.next();
        char[] nArr = strNum.toCharArray();
        
        for(int i = 1; i<nArr.length; i++){
            if(nArr[i-1] == nArr[i]){
                String preNum = strNum.substring(0, i-1);
                String postNum = strNum.substring(i);
                String number = preNum + postNum;
                int temp = Integer.valueOf(number);
                if(temp > max){
                    max = temp;
                }
            }
        }
        if(max == 0)
        System.out.println(strNum);
        else
        System.out.println(max);
        
    }
}

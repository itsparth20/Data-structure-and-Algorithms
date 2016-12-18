/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.Scanner;

/**
 *
 * @author itspa
 */
public class HammingDistance {
    public static void main(String[] args) {
        int x,y, chng = 0; 

        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);
        //System.out.println(xStr);
        //System.out.println(yStr);
        char[] xArr = xStr.toCharArray().length < yStr.toCharArray().length ? yStr.toCharArray() : xStr.toCharArray();
        char[] yArr = xStr.toCharArray().length < yStr.toCharArray().length ? xStr.toCharArray() : yStr.toCharArray();
        
        int lSmall = xArr.length < yArr.length ? xArr.length : yArr.length;
        int lBig = xArr.length < yArr.length ? yArr.length : xArr.length ;
        int iBValue = lBig-1;
        int iSValue = lSmall-1;
        for(int i=lSmall-1; i>=0; i--){
            if(xArr[iBValue--] != yArr[iSValue--]) {
                chng++;
            }
        }
        for(int i=iBValue; i>=0; i--){
            char te = xArr[i];
            char mp = '1';
            if(te == '1'){
                chng++;
            }
        }
        System.out.println(chng);
    }
    

    
}

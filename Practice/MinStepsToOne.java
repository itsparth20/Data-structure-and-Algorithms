/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.ArrayList;

/**
 *
 * @author itspa
 * 
 * /*
 *  2. Minimum Steps to One
 *
 *     Given a positive integer, you can perform any combination of these 3 steps:
 *      1.) Subtract 1 from it.
 *      2.) If its divisible by 2, divide by 2. 
 *      3.) If its divisible by 3, divide by 3.
 *
 *     Find the minimum number of steps that it takes get from N to 1
 * 
 *  Input: Positive Integer N
 *  Output:Integer
 */
public class MinStepsToOne {
    public static void main(String[] args){
        System.out.println(minStepsToOne(5));
    }

    private static int minStepsToOne(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        
        for(int i =4; i<=n; i++){
            int minWay = Integer.MAX_VALUE;
            int ways = list.get(i-1)+1;
            minWay = Math.min(ways, minWay);
            if(i%2 ==0){
                ways = list.get(i/2)+1;
                minWay = Math.min(ways, minWay);
            }
            if(i%3 ==0){
                ways = list.get(i/3)+1;
                minWay = Math.min(ways, minWay);
            }
            list.add(minWay);
        }
        return list.get(n);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        int[] h = {1,2,3,4,7};
        int[] t = {1,6};        
        Heaters hobj = new Heaters();
        System.out.println(hobj.findRadius(h, t));
    }
}

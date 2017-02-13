/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navisens;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itspa
 */
public class FindN {
    
    private static Map<Long, Double> map;
    public static void main(String[] args){
        map = new HashMap<Long,Double>();
        System.out.println(f(8181));
    }

    private static Double f(long n) {
        if (n == 0) {
            return 0.0;
        }
        if (n == 1) { 
            return 1.0;
        }
        if (map.get(n) != null) {
            return map.get(n);
        } else {
            Double v = f(n - 1) + f(n - 2);
            map.put(n, v);
            return v;
      }
    }
}

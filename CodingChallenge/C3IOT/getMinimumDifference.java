/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C3IOT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author itspa
 */

/*
Check how many modification we can make to make string anagram
We cannot add or remove character.
*/
public class getMinimumDifference {
    public static void main(String[] args){
        String[] a = new String[1];
        String[] b = new String[1];
        Scanner sc = new Scanner(System.in);
        for(int i =0; i< 1; i++){
            a[i] = sc.nextLine();
        }
        for(int i =0; i< 1; i++){
            b[i] = sc.nextLine();
        }
        
        getMinimumDifference(a,b);
    }
    
    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] diff = new int[a.length];
        for(int i = 0; i<a.length; i++){
            String first = a[i];
            String second = b[i];
            int count = 0;
            
            if(first.length() == second.length()){
                HashMap<Character,Integer> map = new LinkedHashMap<>();
                for(int j =0; j<first.length(); j++){
                    if(map.containsKey(first.charAt(j))){
                        map.put(first.charAt(j), map.get(first.charAt(j))+1);
                    }
                    else{
                        map.put(first.charAt(j), 1);
                    }
                }
                for(int j =0; j<second.length(); j++){
                    if(map.containsKey(second.charAt(j))){
                        if(map.get(second.charAt(j))<= 0){
                            count++;
                        }
                        else{
                            map.put(second.charAt(j), map.get(second.charAt(j))-1);
                        }
                    }else{
                        count++;
                    }
                }
                diff[i] = count;
            }else{
                diff[i] = -1;
            }
        }
        return diff;
    }
}

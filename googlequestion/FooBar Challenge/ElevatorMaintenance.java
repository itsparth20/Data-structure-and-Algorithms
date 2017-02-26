/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion.FooBar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author itspa
 */

public class ElevatorMaintenance {
    public static void main(String[] args){
        String[] l = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
        String[] arr = answer(l);
        List<String> list = Arrays.asList(arr);
        list.forEach(System.out::println);
    }

    public static String[] answer(String[] l) { 

        List<String> list = Arrays.asList(l);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                String[] arrFirstString = firstString.split("\\.");
                String[] arrSecondString = secondString.split("\\.");
                
                if(Integer.parseInt(arrFirstString[0]) > Integer.parseInt(arrSecondString[0]) ){
                    return 1;
                }
                else if(Integer.parseInt(arrFirstString[0]) < Integer.parseInt(arrSecondString[0])) {
                    return -1;
                }
                else{
                    if(arrFirstString.length > 1 && arrSecondString.length > 1){
                        if(Integer.parseInt(arrFirstString[1]) > Integer.parseInt(arrSecondString[1]) ){
                            return 1;
                        }
                        else if(Integer.parseInt(arrFirstString[1]) < Integer.parseInt(arrSecondString[1])) {
                            return -1;
                        }else{
                            if(arrFirstString.length > 2 && arrSecondString.length > 2){
                                if(Integer.parseInt(arrFirstString[2]) > Integer.parseInt(arrSecondString[2]) ){
                                    return 1;
                                }                                
                                return -1;                                
                            }
                            else if(arrFirstString.length > 2){
                                return 1;
                            }
                        }
                    }
                    else if(arrFirstString.length > 1){
                        return 1;
                    }                    
                }
                return -1;
            }
        });
        return l;
    } 

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrChron;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;
/**
 *
 * @author itspa
 */
public class DuplicateNames {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Map<String, String> nonDuplicate = new LinkedHashMap<String, String>();
        Pattern checkRegex = Pattern.compile("\\d{9}");   
        int no = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<no; i++){
            String s = sc.nextLine();
            Matcher regexMatcher = checkRegex.matcher(s);
            
            while ( regexMatcher.find() ){   

                if(!nonDuplicate.containsKey(regexMatcher.group().trim())){
                    String name = s.split(":")[0];
                    nonDuplicate.put(regexMatcher.group().trim(), name);
                }
                else{
                    String name = s.split(":")[0].trim();                                        
                    if(name.length() > nonDuplicate.get(regexMatcher.group().trim()).length() || 
                            (name.contains(",") && name.length() == nonDuplicate.get(regexMatcher.group().trim()).length())){
                        nonDuplicate.put(regexMatcher.group().trim(), name);
                    }
                }                
            }                        
        } 
        System.out.println("");
        int count =0;
        for(String ssn : nonDuplicate.keySet()){
            String[] arr = nonDuplicate.get(ssn).split(",");
            StringBuffer sb = new StringBuffer();
            if(arr.length == 2){
                sb.append(arr[1]);
                sb.append(" ");
            }
            sb.append(arr[0]);
            sb.append(":");
            sb.append(ssn);
            System.out.println(sb.toString());
            count++;
        }
        System.out.println(count);
        
    
    }
}

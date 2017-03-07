package DrChron;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */

import java.util.regex.*;

public class PatternSearch {
    public static void main(String[] args){
        
        String matchPattern = "AB*D";
        String check = "ABCDDCDABCDABCDDDCDA";                        
        System.out.println(findTotalMatch(matchPattern ,check));
        
    }

    private static int findTotalMatch(String matchPattern, String check) {
        int count = 0;
        String regex = matchPattern.replace("*", "\\w");
        
        Pattern checkRegex = Pattern.compile(regex);        
        Matcher regexMatcher = checkRegex.matcher( check );
        
        while ( regexMatcher.find() ){                        
            count++;
        }        
        return count;
    }
}

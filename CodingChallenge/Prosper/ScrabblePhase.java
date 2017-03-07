/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProsperChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author itspa
 */
/*
Task: Start Building a scrabble AI

You will be given a list of over 100,000 legal English words, the "dictionary".
You wull also be given a list of a smallish number of letters, between 3 and 20 
possibly with repetition, the "slate". "Slate" is string. your goal is to return
a sorted list of all the legal English words (i.e. words in the dictionary) at 
least 2 letters long that can be formed with some or all of the letters on your
slate. Everything sould be treated as lower-case; if the word "Mary" is in the 
dictionary and you have the letter "amry" then you can and must include the word
"mary" in the list of words that you return.

For Example:
if your slate is "cta", and assuming dictionary file was a good list of English words, 
some of the words you expected to product might be "act", "at", "cat", and so on. 
Again, the list you return must be in sorted order, and must all e lower-case, and
the matching against the dictionary must be done case-insensitively.

Note: return all word that can be form using word slate. Length should be greater then 1 
      and reuslt array should be sorted.
*/
public class ScrabblePhase {
    
    public static void main(String[] args){
        String slate = "tac";
        String[] dic = {"at", "tac", "235886", "caca","tacca", "act"};
        String[] temp = FindWords(slate, dic);
        for(int i = 0; i<temp.length; i++){
            System.out.println(temp[i]);
        }
    }
        static String[] FindWords(String slate, String[] dictionary) {
        
        Set<String> set = new HashSet<String>();
        String copySlate = slate.toLowerCase();
        char[] chars = copySlate.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        Arrays.sort(dictionary);
        HashMap map = new HashMap();
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i], (int)map.get(chars[i])+1);
            }else{
                map.put(chars[i], 1);
            }
        }
        HashMap mapCopy = new HashMap();
        mapCopy = (HashMap)map.clone();
        for(int i = 0; i < dictionary.length; i++){
            String word = dictionary[i].toLowerCase();
            if(word.length() > 1){
                char[] wordChar = word.toCharArray();
                Arrays.sort(wordChar);
                String sortedWord = new String(wordChar);
                boolean contrains = true;
                for(int j = 0; j < sortedWord.length(); j++){
                    char x = sortedWord.charAt(j);
                    if(contrains == true && !sorted.contains(String.valueOf(x))){                      
                        contrains = false;
                        break;                        
                    }
                    int te = (int) mapCopy.get(x);
                    if((int)mapCopy.get(x) == 0){
                        contrains = false;
                        break;                        
                    }else{
                        mapCopy.put(x,(int)mapCopy.get(x)-1);
                    }
                }
                if(contrains){
                    set.add(word);
                }
            }
            mapCopy = (HashMap)map.clone();
        }
        String[] returnStringArr = set.toArray(new String[set.size()]);
        Arrays.sort(returnStringArr);
        return returnStringArr;

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.HashSet;

/**
 *
 * @author itspa
 */
public class AnagramPalindrom {
    public static void main(String[] args) {
        System.out.println(anagramPalindrom("outco"));
        System.out.println(anagramPalindrom("121"));
        System.out.println(anagramPalindrom("1122"));
    }

    private static boolean anagramPalindrom(String input) {
        HashSet<Character> lib = new HashSet<Character>();
        
        for(int i = 0; i<input.length(); i++){
            if(lib.contains(input.charAt(i)))
                lib.remove(input.charAt(i));
            else
                lib.add(input.charAt(i));
        }
        if(lib.size() > 1)
            return false;
        
        return true;
    }
}

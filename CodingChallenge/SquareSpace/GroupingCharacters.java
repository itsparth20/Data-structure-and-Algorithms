/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SquareSpace;

import java.util.*;
/**
 *
 * @author itspa
 */

/*
Problem: Grouping Characture

Write method that tests if the grouping character [], (), {} and <> in a string are balanced, any group that is open must be closed with a corrosponding characters.

Grouping characters can be escaped by using a backslash character. The Character following a backslash character will be ignored, even if it is a grouping character.

In addition to the standard grouping characters string delimiters " and ' are also supported inside a string, aa grouping characters are automatically escaped and should be ignored. String delimiters must be balanced in the same ways as others grouping characters -- each ' or " must be closed with a corresponding ' or ".

() true
([)] false
( false
(abc) true
"{" true
'abc' true
'<\' false


*/
class GroupingCharacters {
    public static boolean isBalanced(String str) {
        Map<Character, Character> brackets = new HashMap<Character,Character>();
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('\"', '\"');
        brackets.put('\'', '\'');
        brackets.put('<', '>');
        if (str.length() == 0) {
            return true;
        }

        final Stack<Character> stack = new Stack<Character>();
        boolean comma = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                continue;
            }
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                continue;
            }
            if(str.charAt(i) == '\\'){
                i++;
                continue;
            }
            
            if(comma){
                if(stack.empty() || str.charAt(i) == brackets.get(stack.peek())){
                    comma = false;
                    stack.pop();
                    continue;
                }
                else{
                    continue;
                }

            }
            if(str.charAt(i) == '\"' || str.charAt(i) == '\''){
                comma = true;
                stack.push(str.charAt(i));
                continue;
            }
            if (brackets.containsKey(str.charAt(i))) {                
                stack.push(str.charAt(i));                
            } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {                
                return false;            
            } 
        }
        if(comma == false && stack.empty())
            return true;
        else
            return false;
    }
    
    public static void main(String args[] ) throws Exception {

        
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("("));
        System.out.println(isBalanced("(abc)"));
        System.out.println(isBalanced("\"(\""));
        System.out.println(isBalanced("\'abc\'"));        
        System.out.println(isBalanced("{\'<\"}")); //{'<"}
        System.out.println(isBalanced("<>"));
        System.out.println(isBalanced("\'<\\\'")); // '<\'
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author itspa
 */

import java.util.*;


class BalancedBrackets
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
            Stack<Character> stack = new Stack<Character>();
            boolean wrongInput = false;
            String s = in.next();
            for(int i = 0 ;i <s.length();i++)
            {
                if(s.charAt(i)== '{' ||s.charAt(i)== '[' || s.charAt(i)== '(')
                {
                    stack.push(s.charAt(i));                    
                }
                else if(s.charAt(i)=='}')
                {
                    if(stack.isEmpty() || stack.pop()!='{'){
                        wrongInput = true;
                        break;
                    }
                }
                else if(s.charAt(i)==']')
                {
                    if(stack.isEmpty() || stack.pop()!='['){
                        wrongInput = true;
                        break;
                    }
                }
                else if(s.charAt(i)==')')
                {
                    if(stack.isEmpty() || stack.pop()!='('){
                        wrongInput = true;
                        break;
                    }
                }
            }
            
            if(wrongInput == true || !stack.isEmpty()){
                System.out.println("NO");
            }
            else
            {
                System.out.println("YES");
            }
        }
    }
}

/*
3
{[()]} YES
{[(])} NO
{{[[(())]]}} YES
*/
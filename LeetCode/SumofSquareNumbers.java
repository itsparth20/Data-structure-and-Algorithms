package practiceProblem.leetcode;

import java.util.HashMap;
import java.util.Map;
/*
 * 633. Sum of Square Numbers
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 */
public class SumofSquareNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(judgeSquareSum(2));
	}

	public static boolean judgeSquareSum(int c) {
        Map<Integer, Integer> map = new HashMap<>();
        int x = (int)Math.sqrt(c);
        for(int i = 0; i <= x; i++){
            int squr = i * i;
            if(map.containsKey(c-squr)){
                return true;
            }
            else{
                if( (squr + squr) == c)
                    return true;
                map.put(squr, c-squr);
            }
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhiteBoardPracticeTree;

/**
 *
 * @author itspa
 */

/*
Given a value N, and a set of different valued coins how many different ways can we make change from these coin values?  

Input:	 Integer and an Array
Output: Integer representing number of ways change can be made
Example
Input: 4, [1,2,3]		=>	Output: 4
(there four ways to make change [1,1,1,1],[1,1,2],[2,2],[1,3])
Input: 10, S = {2,3,5,6}	=>	Output: 5
(there are five ways [2,2,2,2,2],[2,2,3,3],[2,3,5],[5,5],[2,2,6])

*/
public class CoinChange {
    public static int count = 0;
    public static int n = 4;
    public static int[] coins = {1,2,3};
    public static void main(String[] args){               
        countChange(n, coins);
        System.out.println(count);
    }

    private static void countChange(int n, int[] coins) {
        
        countNumOfWays(0, coins.length-1);
        
    }

    private static void countNumOfWays(int total, int length) {
        if(total == n){
            count++;
        }
        else if(total < n){
            for(int i = 0; i<=length; i++){
                countNumOfWays(total+coins[i], i);
            }
        }
    }
}

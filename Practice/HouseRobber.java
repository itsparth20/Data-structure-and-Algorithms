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
House Robber
A house robber has a map of houses and the amount of gold in each home.  The robber knows that if two adjacent homes are robbed, then the neighborhood security system will sound.  Determine the total amount of gold the robber can get without setting off the alarm.

Input: 		Array of Nonnegative Integers
Output: 	Integer
Example
Input: [1, 2, 3]				=>	Output: 4
Input: [1, 2, 4, 1, 5, 12, 5]	=>	Output: 17

*/
public class HouseRobber {
    public static void main(String[] args){
        int[] goldInHouse = {1,2,4,1,5,12,5};
        
        System.out.println(totalAmountOfGold(goldInHouse));
    }

    private static int totalAmountOfGold(int[] goldInHouse) {
        if(goldInHouse.length == 0){
            return 0;
        }
        if(goldInHouse.length == 1){
            return goldInHouse[0];
        }
        if(goldInHouse.length == 2){
            return goldInHouse[goldInHouse.length-1] > goldInHouse[goldInHouse.length-2] ? goldInHouse[goldInHouse.length-1] : goldInHouse[goldInHouse.length-2];
        }
        goldInHouse[2] += goldInHouse[0];
        for(int i=3; i<goldInHouse.length; i++){
            goldInHouse[i] += goldInHouse[i-2] > goldInHouse[i-3] ? goldInHouse[i-2] : goldInHouse[i-3];
        }
        return goldInHouse[goldInHouse.length-1] > goldInHouse[goldInHouse.length-2] ? goldInHouse[goldInHouse.length-1] : goldInHouse[goldInHouse.length-2];
    }
}

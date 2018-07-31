package com.leetcode.coinchange;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
/*
322. Coin Change
https://leetcode.com/problems/coin-change/description/
You are given coins of different denominations and a total
amount of money amount. Write a function to compute the fewest
number of coins that you need to make up that amount. If that amount
of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1

 */
public class CoinChange {
    private int change = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount){
        if (amount == 0) return amount;
        Arrays.sort(coins);
        findNumberOfCoinToReturn(coins, amount, coins.length-1, 0, 0);
        return change == Integer.MAX_VALUE ? -1 : change;
    }

    private int findNumberOfCoinToReturn(int[] coins, int amount, int i, int total, int noOfCoins){
        if(amount == total){
            return noOfCoins;
        }
        if(amount < total || noOfCoins >= change){
            return Integer.MAX_VALUE;
        }


        //during for loop check for index value
        for(int k = i; k >= 0; k--){
            int left = findNumberOfCoinToReturn(coins, amount, k, coins[k]+total, noOfCoins+1);
            int right = findNumberOfCoinToReturn(coins, amount, k-1, total, noOfCoins);
            change = Math.min(left, right);

        }
        return change;
    }

    private CoinChange obj;

    @Before
    public void setUp(){
        obj = new CoinChange();
    }

    @Test
    public void testCoinChangeSimple() {
        int[] coins = {1,2,5};
        int amount = 11;

        assertEquals(3, obj.coinChange(coins, amount));
    }

    @Test
    public void testCoinChangeNegative() {
        int[] coins = {2};
        int amount = 3;

        assertEquals(-1, obj.coinChange(coins, amount));
    }

}

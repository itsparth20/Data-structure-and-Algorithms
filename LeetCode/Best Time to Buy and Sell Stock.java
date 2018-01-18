/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int buy = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] - buy > profit){
                profit = prices[i] - buy;                
            }
            if(buy > prices[i]){
                buy = prices[i];
            }
        }
        return profit;
    }
}
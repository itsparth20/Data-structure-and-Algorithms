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
Knapsack Problem 0/1
Given a set of items where each item has a weight and a value. And given a knapsack with max weight capacity, determine the maximum value that can be placed into the knapsack without going over the capacity.

Input: An integer array of weights
           An integer array of values
           The ith item is weights[i] and values[i].	
Output: Integer of maximum total value
Example
Input: 
	value =  [60, 100, 120]
weight = [10, 20, 30]
capacity = 50





Output: 220
Knapsack Problem 0/1
Given a set of items where each item has a weight and a value. And given a knapsack with max weight capacity, determine the maximum value that can be placed into the knapsack without going over the capacity.

Input: An integer array of weights
           An integer array of values
           The ith item is weights[i] and values[i].	
Output: Integer of maximum total value
Example
Input: 
	value =  [60, 100, 120]
weight = [10, 20, 30]
capacity = 50





Output: 220
Knapsack Problem 0/1
Given a set of items where each item has a weight and a value. And given a knapsack with max weight capacity, determine the maximum value that can be placed into the knapsack without going over the capacity.

Input: An integer array of weights
           An integer array of values
           The ith item is weights[i] and values[i].	
Output: Integer of maximum total value
Example
Input: 
	value =  [60, 100, 120]
weight = [10, 20, 30]
capacity = 50





Output: 220
Knapsack Problem 0/1
Given a set of items where each item has a weight and a value. And given a knapsack with max weight capacity, determine the maximum value that can be placed into the knapsack without going over the capacity.

Input: An integer array of weights
           An integer array of values
           The ith item is weights[i] and values[i].	
Output: Integer of maximum total value
Example
Input: 
	value =  [60, 100, 120]
weight = [10, 20, 30]
capacity = 50





Output: 220
Knapsack Problem 0/1
Given a set of items where each item has a weight and a value. And given a knapsack with max weight capacity, determine the maximum value that can be placed into the knapsack without going over the capacity.

Input: An integer array of weights
           An integer array of values
           The ith item is weights[i] and values[i].	
Output: Integer of maximum total value
Example
Input: 
value =  [60, 100,120] 
weight = [10, 20, 30]
capacity = 50
oUTPUT: 220
*/
public class KnapsackProblem {
    public static void main(String[] args){
        int[] value = {60,100,120};
        int[] weight = {10,20,30};
        int capacity = 50;
        
        System.out.println(maximumValue(value, weight, capacity));
    }
    public static int max = 0;
    private static int maximumValue(int[] value, int[] weight, int capacity) {
        
        helperMethod(value,weight, capacity, 0, 0, 0);
        return max;
    }

    private static void helperMethod(int[] value, int[] weight, int capacity, int totalValue, int totalWeight, int index) {
        if(totalWeight <= capacity){
            if(max < totalValue) 
                max = totalValue;
         
        }
        if(capacity < totalWeight){
            return;
        }
        
        for(int i = index; i<weight.length; i++){
            helperMethod(value, weight, capacity, totalValue + value[i], totalWeight + weight[i], index + 1);
            helperMethod(value, weight, capacity, totalValue, totalWeight, index + 1);
        }
    }
}

/*
Pascal's Triangle II

https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/1660/

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]

*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<List<Integer>> outerList = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<Integer>();
            int lastIndex = i+1;
            for (int j = 0; j < lastIndex; j++) {
                list.add(helper(i,j, outerList));
            }
            outerList.add(list);
        }
        return outerList.get(rowIndex);
    }
    
    public int helper(int i, int j, List<List<Integer>> outerList){
        
        if (outerList.size() > i && outerList.get(i).size() > j){    
            return outerList.get(i).get(j);
        }
        else if (j == 0 || j == i){
            return 1;
        }
        else{
            return helper(i-1,j-1, outerList) + helper(i-1,j, outerList);
        }
    } 
}

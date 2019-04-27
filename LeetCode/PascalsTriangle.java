/*
118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outerList = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<Integer>();
            int lastIndex = i+1;
            for (int j = 0; j < lastIndex; j++) {
                list.add(helper(i,j, outerList));
            }
            outerList.add(list);
        }
        return outerList;
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
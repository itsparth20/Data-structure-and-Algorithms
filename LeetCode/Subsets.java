/*
78. Subsets
https://leetcode.com/problems/subsets/description/
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> addList = new ArrayList<>();
        list.add(addList);
        callHelper(list, nums, 0, addList);
        return list;
    }
    public void callHelper(List<List<Integer>> list, int[] nums, int j, List<Integer> addList){
        if(j < nums.length){
            for(int i = j; i < nums.length; i++){
                List<Integer> lst =  new ArrayList<>(addList);
                lst.add(nums[i]);
                list.add(lst);        
                callHelper(list, nums, i+1, lst);
            }
        }
    }
}
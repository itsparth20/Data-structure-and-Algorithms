/*
118. Pascal's Triangle
https://leetcode.com/problems/pascals-triangle/description/
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        if(numRows < 1) return lst;
        lst.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows < 2) return lst;
        lst.add(new ArrayList<>(Arrays.asList(1, 1)));
        if(numRows < 3) return lst;
        int i = 3;
        while(i <= numRows){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 0; j < lst.get(i-2).size()-1; j++){
                list.add(lst.get(i-2).get(j)+lst.get(i-2).get(j+1));
            }
            list.add(1);
            lst.add(list);
            i++;
        }
        return lst;
    }
}
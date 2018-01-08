/*
46. Permutations
https://leetcode.com/problems/permutations/description/
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.putIfAbsent(i,0);
            map.put(i, map.get(i)+1);
        }
        
        Integer[] digit = new Integer[map.size()];
        Integer[] count = new Integer[map.size()];
        Integer[] result = new Integer[map.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            digit[i] = entry.getKey();
            count[i++] = entry.getValue();
        }
        generatePermute(digit, count, 0, permutation, result);
        return permutation;
    }
    
    public void generatePermute(Integer[] digit, Integer[] count, int level, List<List<Integer>> permutation, Integer[] result){
        if(level == count.length) {
            List<Integer> list = new ArrayList<>(Arrays.asList(result));
            permutation.add(list);
            return;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0) continue;
            count[i]--;
            result[level] = digit[i];
            generatePermute(digit, count, level+1, permutation, result);
            count[i]++;
        }
        
    }
}
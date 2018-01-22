/*
128. Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/description/
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int maxSequence = 0;
        for(int i : set){
            if( !set.contains(i-1)){
                int currentNum = i;
                int sequence = 1;
                
                while(set.contains(currentNum+1)){
                    currentNum+=1;
                    sequence += 1;
                }
                
                if(maxSequence < sequence) maxSequence = sequence;
            }
        }
        return maxSequence;
    }
}
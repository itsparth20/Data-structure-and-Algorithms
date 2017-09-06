//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

//373. Find K Pairs with Smallest Sums

class Solution {
    public List<int[]> kSmallestPairs(int[] num1, int[] num2, int k) {
        List<int[]> result = new ArrayList<>();
        if(num1.length == 0 || num2.length == 0 || k == 0) return result;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]+a[1]-b[0]-b[1]);
        for(int i = 0; i < num1.length && i < k; i++){
            q.offer(new int[]{num1[i], num2[0], 0});
        }
        while(k-- > 0 && !q.isEmpty()){
            int[] curr = q.poll();
            result.add(new int[]{curr[0], curr[1]});
            if(curr[2] == num2.length-1) continue;
            q.add(new int[]{curr[0], num2[curr[2]+1], curr[2]+1});
        }
        return result;
    }
}
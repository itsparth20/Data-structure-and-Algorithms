package com.rescale.platform.transfer;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            int temp = findMax(arr, i);
            max = temp > max ? temp : max;
        }

        return max;
    }

    public int findMax(int[] arr, int start){
        if (arr.length <= start) {
            return Integer.MIN_VALUE;
        } else if (arr.length <= start+1) {
            return 1;
        }


        Set<Integer> set = new HashSet<>();
        set.add(arr[start]);
        int count = 1;
        for(int i = start+1; i < arr.length; i++, count++) {
            if (set.add(arr[i])) {
                if (set.size() > 2) {
                    return count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = {1, 2, 1, 3, 4, 3, 5, 1, 2};
        int[] b = {1, 2, 1, 2,1,2,1} ;

        System.out.println(obj.solution(arr));
        System.out.println(obj.solution(b));

    }
}

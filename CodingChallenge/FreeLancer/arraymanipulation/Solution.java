package com.freelance.arraymanipulation;// you can also use imports, for example:
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] A) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        int no = 0;
        int size = list.size();
        boolean acc;
        for(int i =0; i < size; i++){
            List<Integer> copy = new ArrayList(list);
            copy.remove(i);
            List<Integer> sorted = new ArrayList(copy);
            Collections.sort(sorted);
            if(sorted.equals(copy)){
                no++;
            }
        }
        return no;
    }

}
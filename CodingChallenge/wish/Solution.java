package com.help.amee;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class Solution {

    static int countDuplicates(int[] numbers) {
        Map<Integer, Boolean> map = new HashMap<>();
        int duplicate_count = 0;
        for (int i : numbers) {
            if (map.containsKey(i)) {
                map.put(i, false);
            } else {
                map.put(i, true);
            }
        }

        for (Boolean value : map.values()) {
            if (!value) {
                duplicate_count++;
            }
        }

        //one line answer
        Arrays.stream(numbers).boxed().collect(Collectors.toMap(p -> p, p -> true, (x, y) -> false)).values().stream().filter(x->!x).count();

        return duplicate_count;
    }

    @Test
    public void testSimple() {
        int[] arr = {1, 3, 1, 4, 5, 6, 3, 2};


        int[] arr1 = {1, 1, 1, 1};
        assertEquals(2, Solution.countDuplicates(arr));
        assertEquals(1, Solution.countDuplicates(arr1));
    }
}



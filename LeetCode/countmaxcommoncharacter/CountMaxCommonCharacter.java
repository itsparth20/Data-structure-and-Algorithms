package com.helper.ebay;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class CountMaxCommonCharacter {
    private static long getTotalCommonCharacterCount(String s1, String s2) {

        Map<String, Long> s1Map = List.of(s1.split("")).stream().collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        Map<String, Long> s2Map = List.of(s2.split("")).stream().collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        int count = s1Map.keySet().stream().filter(k -> s2Map.containsKey(k)).map(k -> s1Map.get(k) > s2Map.get(k) ? s1Map.get(k) : s2Map.get(k)).mapToInt(i -> i.intValue()).sum();
        return count;
    }

    @Test
    public void simpleTest() {
        String s1 = "abbaccdb";
        String s2 = "aaaaaabbzdddddddx";

        assertEquals(16, CountMaxCommonCharacter.getTotalCommonCharacterCount(s1, s2));
    }
}

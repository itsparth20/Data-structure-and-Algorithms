package com.leetcode.factorialtrailingzeroes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int fives = 0;
        int five = 5;

        while (n >= 5) {
            n /= five;
            fives += n;
        }

        return fives;
    }

    @Test
    public void testTrailingZeroes() {
        assertEquals(24, new FactorialTrailingZeroes().trailingZeroes(100));
        assertEquals(6, new FactorialTrailingZeroes().trailingZeroes(25));
        assertEquals(0, new FactorialTrailingZeroes().trailingZeroes(0));
        assertEquals(2, new FactorialTrailingZeroes().trailingZeroes(10));
    }

    @Test
    public void testTrailingZeroesWithBigNumber() {
        assertEquals(452137076, new FactorialTrailingZeroes().trailingZeroes(1808548329));
    }

}

package com.leetcode.basiccalculatorII;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/description/
//227. Basic Calculator II

import static junit.framework.TestCase.assertEquals;

public class BasicCalculatorII {

    public int calculate(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int number = 0;

        for (int index = 0; index < input.length(); index++) {
            if (isDigit(input.charAt(index))) {
                number = 10 * number + input.charAt(index) - '0';
            }
            if ((!isDigit(input.charAt(index)) && input.charAt(index) != ' ') || index == input.length() - 1) {
                if (sign == '-') {
                    stack.push(-number);
                }
                if (sign == '+') {
                    stack.push(number);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = input.charAt(index);
                number = 0;
            }
        }
        int result = 0;
        for (int value : stack) {
            result += value;
        }
        return result;
    }

    private boolean isDigit(char value) {
        return value >= '0' && value <= '9';
    }

    BasicCalculatorII obj;

    @Before
    public void setup() {
        obj = new BasicCalculatorII();
    }

    @Test
    public void simpleTestForCalculator() {
        String input = "3+2*2";
        assertEquals(7, obj.calculate(input));
    }

    @Test
    public void testDivide() {
        String input = "3/2 ";
        assertEquals(1, obj.calculate(input));
    }

    @Test
    public void testPlusAndDivide() {
        String input = "3+5 / 2";
        assertEquals(5, obj.calculate(input));
    }

    @Test
    public void testPlusAndMultiplication() {
        String input = "3+2*2";
        assertEquals(7, obj.calculate(input));
    }
}

package com.leetcode.fizzbuzz;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
412. Fizz Buzz

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number
and for the multiples of five output “Buzz”.
For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        return IntStream.range(1, n + 1).mapToObj(i -> {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0 && i % 5 == 0) {
                return "FizzBuzz";
            }

            else if (i % 3 == 0) {
                return "Fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            } else {
                return String.valueOf(i);
            }
        }).collect(Collectors.toList());
    }
}

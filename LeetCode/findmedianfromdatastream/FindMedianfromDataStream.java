package com.leetcode.findmedianfromdatastream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
295. Find Median from Data Stream

https://leetcode.com/problems/find-median-from-data-stream/description/

Median is the middle value in an ordered integer list. If the size of the
list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

 */

public class FindMedianfromDataStream {
}

class MedianFinder {

    /** initialize your data structure here. */
    private List<Integer> numbers;
    private int size;
    public MedianFinder() {
        numbers = new ArrayList<>();
        size = 0;
    }

    public void addNum(int num) {
        numbers.add(num);
        size++;
    }
    private int index;
    public double findMedian() {
        if(size == 1) return numbers.get(0);
        Collections.sort(numbers);
        index = size/2;
        double value = ((double)(numbers.get(index)+numbers.get(index-1)))/2;
        return size%2==0 ? value : numbers.get(index);
    }
}

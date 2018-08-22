package com.leetcode.flattennestedlistiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
341. Flatten Nested List Iterator

https://leetcode.com/problems/flatten-nested-list-iterator/description/

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,4,6].
 */

public class FlattenNestedListIterator {
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * */
 interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
 }

class NestedIterator implements Iterator<Integer> {
    private static List<Integer> lst;

    int size;
    int i;
    public NestedIterator(List<NestedInteger> nestedList) {
        lst = new ArrayList<Integer>();
        populateList(nestedList, lst);
        size = lst.size();
        i = 0;

    }

    private static void populateList(List<NestedInteger> nestedList, List<Integer> lst){
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                lst.add(n.getInteger());
            }
            else{
                populateList(n.getList(), lst);
            }
        }
    }

    @Override
    public Integer next() {
        return lst.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i<size;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
package com.leetcode.theskylineProblem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

//218. The Skyline Problem
//https://leetcode.com/problems/the-skyline-problem/description/

public class SkylineProblem {
    private SkylineProblem obj;

    class CordinateAndPoint implements Comparable{
        int x;
        boolean isStart;
        int height;

        public CordinateAndPoint(int x, boolean isStart, int height) {
            this.x = x;
            this.isStart = isStart;
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            CordinateAndPoint obj = (CordinateAndPoint)o;
            if (x != obj.x) {
                return x - obj.x;
            }
            else{
                if (isStart && obj.isStart) {
                    return  obj.height - height;
                }
                else if (!isStart && !obj.isStart){
                    return height - obj.height;
                }
                else{
                    return isStart ? -1 : 1;
                }
//                return (isStart ? -height : height) - (obj.isStart ? -obj.height : obj.height);
            }
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> output = new ArrayList<>();

        CordinateAndPoint[] cordinateArr = getCordinateArray(buildings);
        TreeMap<Integer, Integer> queue = new TreeMap<>();

        queue.put(0, 1);

        int previousHeight = 0;
        for (CordinateAndPoint cordinate : cordinateArr) {
            if (cordinate.isStart) {
                queue.merge(cordinate.height, 1, Integer::sum);
            } else {
                queue.merge(cordinate.height, -1, Integer::sum);
                if (queue.get(cordinate.height) == 0) {
                    queue.remove(cordinate.height);
                }
            }

            int currentHeight = queue.lastKey();
            if (currentHeight != previousHeight) {
                output.add(new int[]{cordinate.x, currentHeight});
                previousHeight = currentHeight;
            }
        }

        return output;
    }

    private CordinateAndPoint[] getCordinateArray(int[][] buildings) {
        CordinateAndPoint[] cordinateArr = new CordinateAndPoint[buildings.length * 2];
        int i = 0;
        for (int[] arr : buildings) {
            CordinateAndPoint start = new CordinateAndPoint(arr[0], true, arr[2]);
            CordinateAndPoint end = new CordinateAndPoint(arr[1], false, arr[2]);
            cordinateArr[i++] = start;
            cordinateArr[i++] = end;
        }
        Arrays.sort(cordinateArr);
        return cordinateArr;
    }

    @Before
    public void setup() {
        obj = new SkylineProblem();
    }

    @Test
    public void testSimpleSkylineProblem() {
        int[][] input = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};

        final int[] e1 = {2, 10};
        int[] e2 = {3, 15};
        int[] e3 = {7, 12};
        int[] e4 = {12, 0};
        int[] e5 = {15, 10};
        int[] e6 = {20, 8};
        int[] e7 = {24, 0};
        List<int[]> outputList = List.of(e1, e2, e3,
                e4, e5, e6, e7);

        List<int[]> output = obj.getSkyline(input);
        assertThat(output, hasItems(e1, e2, e3, e4, e5, e6, e7));
        assertEquals(7, output.size());
    }

    @Test
    public void testWithTwoArray() {
        int[][] input = {{0, 2, 3}, {2, 5, 3}};
        int[] e1 = {0, 3};
        int[] e2 = {5, 0};
        List<int[]> outputList = List.of(e1, e2);
        List<int[]> output = obj.getSkyline(input);
        assertThat(output, hasItems(e1, e2));
        assertEquals(2, output.size());
    }
}

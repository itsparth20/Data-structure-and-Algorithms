package com.combinesortedarray;

import java.util.Arrays;

import static java.lang.Math.min;


public class main {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7};
        int[] arr2 = {2, 8, 10};
        int[] arr3 = {3, 5, 6, 9};

        int x, y, z, arr1length, arr2length, arr3length, totolLength;
        x = y = z = 0;
        arr1length = arr1.length;
        arr2length = arr2.length;
        arr3length = arr3.length;
        totolLength = arr1length + arr2length + arr3length;

        int[] temp = getMergedArray(arr1, arr1length, arr2, arr2length, arr1length + arr2length);
        int[] arr4 = getMergedArray(temp, temp.length, arr3, arr3length, temp.length + arr3length);
        System.out.println(Arrays.toString(arr4));
    }

    private static int[] getMergedArray(int[] arr1, int arr1Length, int[] arr2, int arr2Length, int n) {
        int[] arr3 = new int[n];
        int i = 0, j = 0, k = 0;
        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        if (i < arr1Length) {
            System.arraycopy(arr1, i, arr3, k, arr1Length - i);
        }
        if (j < arr2Length) {
            System.arraycopy(arr2, j, arr3, k, arr2Length - j);
        }
        return arr3;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */

/*
*  Homework VI
*
*  Problem 1: Quicksort
*
*  Prompt:    Given an unsorted array of integers, return the array
*             sorted using quicksort.
*
*             What are the time and auxilliary space complexity?
*
*  Input:     An unsorted array of integers
*  Output:    A sorted array of integers
*
*  Example:   input = [3,9,1,4,7] , output = [1,3,4,7,9]
*
*
*  Problem 2: Mergesort
*
*  Prompt:    Given an unsorted array of integers, return the array
*             sorted using mergesort.
*
*             What are the time and auxilliary space complexity?
*
*  Input:     An unsorted array of integers
*  Output:    A sorted array of integers
*
*  Example:   input = [3,9,1,4,7] , output = [1,3,4,7,9]
*
*/

import java.util.*;

// Time Complexity: O(nlogn)
// Auxiliary Space Complexity: O(logn) 
class Quicksort{
  //your work here


  public static int[] compute(int[] input) {
//    output = input;
    divide(input, 0, input.length - 1);
    return input;
  }

  private static void divide(int[] input, int begin, int end){
      if(begin<end){          
          int pivot = partition(input, begin, end);
          divide(input, begin, pivot-1);
          divide(input, pivot+1, end);
      }
  }

  private static void swap(int[] arr, int i,int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }

    private static int partition(int[] input, int begin, int end) {
        int pivot = input[end];
        
        int i = begin-1;
        
        for(int j = begin; j <= end-1; j++){
            if(input[j] <= pivot){
                i++;
                swap(input, i, j);
            }
        }
        
        swap(input, i+1, end);
        return i+1;
    }
}


// Time Complexity: O(nlogn)
// Auxiliary Space Complexity: O(n) 
class Mergesort{
  //your work here
  public static int[] sortedArr;
  public static int[] compute(int[] input) {
      sortedArr = input.clone();
      int l =0, r = sortedArr.length-1;
      
      sortArr(l, r);
      return sortedArr;
  }

  private static void merge(int[] sortedArr, int l, int m, int r){
      int n1 = m-l+1;
      int n2 = r-m;
      int leftArr[] = new int[n1];
      int rightArr[] = new int[n2];
      
      for(int i =0; i< n1; i++){
          leftArr[i] = sortedArr[l+i];
      }
      for(int i =0; i< n2; i++){
          rightArr[i] = sortedArr[m+i+1];
      }
      
      int i = 0, j = 0, k = l;
      
      while(i<n1 && j<n2){
          if(leftArr[i] < rightArr[j]){
              sortedArr[k] = leftArr[i];
              i++;
          }else{
              sortedArr[k] = rightArr[j];
              j++;
          }
          k++;
      }
      
      while(i<n1){
          sortedArr[k] = leftArr[i];
          i++;
          k++;
      }
      while(j<n2){
          sortedArr[k] = rightArr[j];
          j++;
          k++;
      }
  }

    private static void sortArr(int l, int r) {
        if(l<r){
            int mid = (l+r)/2;
            sortArr(l, mid);
            sortArr(mid+1, r);
            merge(sortedArr, l, mid, r);
        }
    }
}


////////////////////////////////////////////////////////////
///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
////////////////////////////////////////////////////////////

public class QuickSortAndMergeSort {
   public static void main(String[] args) {
    int[] input = { 3, 9, 1, 4, 7 };

    printList(Mergesort.compute(input));
    printList(Quicksort.compute(input));
  }

    private static void printList(int[] result){
    System.out.print("[ ");
    for(int i : result){
      System.out.print(i + " ");
    }
    System.out.print("]");
  }
}

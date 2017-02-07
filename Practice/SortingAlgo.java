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
* Homework IV
*
* Problem 1: Insertion Sort
*
* Prompt:    Given an unsorted array of integers, return the array
*            sorted using insertion sort.
*
*            What are the time and auxilliary space complexity?
*
* Input:     An unsorted array of integers
* Output:    A sorted array of integers
*
* Example:   input = [3,9,1,4,7] , output = [1,3,4,7,9]
*
*
*
* Problem 2: Selection Sort
*
* Prompt:    Given an unsorted array of integers, return the array
*            sorted using selection sort.
*
*            What are the time and auxilliary space complexity?
*
* Input:     An unsorted array of integers
* Output:    A sorted array of integers
*
* Example:   input = [3,9,1,4,7] , output = [1,3,4,7,9]
*
*
*
* Problem 3: Bubble Sort
*
* Prompt:    Given an unsorted array of integers, return the array
*            sorted using bubble sort.
*
*            What are the time and auxilliary space complexity?
*
* Input:     An unsorted array of integers
* Output:    A sorted array of integers
*
* Example:   input = [3,9,1,4,7] , output = [1,3,4,7,9]
*/


class BasicSort {

  // Time Complexity: O(n^2)
  // Auxiliary Space Complexity: O(1) 
  public static int[] insertion(int[] input) {      
      for(int i =0;i<input.length;i++){          
          for(int j = i; j>0; j--){
              if(input[j]>=input[j-1]){
                  break;
              }
              int temp = input[j];
              input[j] = input[j-1];
              input[j-1] = temp;
          }
      }
      return input;
  }


  // Time Complexity: O(n^2)
  // Auxiliary Space Complexity: O(1)
  public static int[] selection(int[] input) {
      
      int index;
      for(int i = 0; i<input.length; i++){          
          index = i;
          for(int j = i+1; j<input.length; j++){
              if(input[index] > input[j]){                  
                  index = j;
              }
          }
          if(i!=index){
              int temp = input[i];
              input[i] = input[index];
              input[index] = temp;
          }
      }
      return input;
  }


  //Time Complexity: O(n^2)
  //Auxiliary Space Complexity: O(1)
  public static int[] bubble(int[] input) {
      for(int i=0; i< input.length; i++){
          boolean flag = false;
          for(int j = 1; j<input.length-i;j++){
              if(input[j-1]>input[j]){
                  flag = true;
                  int temp = input[j-1];
                  input[j-1] = input[j];
                  input[j] = temp;
              }
          }
          if(flag == false){
              break;
          }
      }
      
      return input;
  }
}

public class SortingAlgo {
    public static void main(String[] args) {
    int[] input = { 3, 9, 1, 4, 7 };

    printList(BasicSort.insertion(input));
    printList(BasicSort.selection(input));
    printList(BasicSort.bubble(input));
  }

  private static void printList(int[] result){
    System.out.print("[ ");
    for(int i : result){
      System.out.print(i + " ");
    }
    System.out.print("]");
  }
}




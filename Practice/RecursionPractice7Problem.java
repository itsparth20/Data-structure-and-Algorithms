/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */
public class RecursionPractice7Problem {
    public static void main(String[] args) {
    int arr[][] = {{1,2,3},{4,5,6},{7,8,9}}; 
    int arr1[] = {1, 4, 7};
    int arr2[] = {2, 3, 6, 9};
    String a = "abc";
    Merge printArray = new Merge();
    System.out.println(printArray.compute(arr1, arr2));
    //run test cases here
    
    }
}

/*
 * 1a. What is the term when the recursive call invokes itself more than once.
 */
    // recursive case

/*
 * 1b. List the steps involved to build a Helper Method Recursion algorithm.
 */
   //create wrapper function and recursive helper function
   //variable to hold state
   //create scope variable
   //create base case in helper to terminate recursion
   //create recursive case

/*
 * 1c. Should the recursive case or base case typically be tackled first?
 */
   //base case

/*
 * 2a. Print each integer in an array in order using Helper Method Recursion
 *
 * Input:   Integer Array
 * Output:  Void
 *
 * Example: int[] nums = {1, 2, 3};
 * 
 *          PrintArray.compute(nums) => 
 *          1
 *          2
 *          3
 */

class PrintArray {

  public static void compute(int[] arr) {
        computeHelper(arr, 0);
  }

  public static void computeHelper(int[] arr, int index) {
        if(index > arr.length-1){
            return;
        }
        System.out.println(arr[index]);
        computeHelper(arr, index+1);
  }

}

/*
 * 2b. Given an integer array, print each item backwards using Helper Method Recursion
 *
 * Input:   Integer Array
 * Output:  Void
 *
 * Example: int[] nums = {1, 2, 3};
 *
 *          PrintReverse.compute(nums) => 
 *          3
 *          2
 *          1
 */

class PrintReverse {

  public static void compute(int[] arr) {
        computeHelper(arr, arr.length-1);
  }

  public static void computeHelper(int[] arr, int index) {
        if(index < 0){
            return;
        }
        System.out.println(arr[index]);
        computeHelper(arr, index-1);
  }

}

/*
 * 2c. Reverse a string using Helper Method Recursion
 *
 * Input:   String
 * Output:  String
 *
 * Example: String greeting = 'hello';
 *          ReverseString.compute(greeting) => 'olleh'
 */

class ReverseString {

  // Can use only computeHelper without wrapper function
  private static int index = 0;
  private static String rev = "";
  public static String compute(String str) {
        
        index = str.length()-1;
        computeHelper(str, rev);
        return rev;
  }

  public static String computeHelper(String input, String output) {
        if(input.length() == output.length()){
            return rev;
        }
        rev += input.charAt(index--);
            
        return computeHelper(input, rev);
  }

}

/*
 * 2d. Given an array of integers, create an array of two-item integer arrays 
 * (two dimensional integer array) using Helper Method Recursion
 *
 * Input:   Array of Integers
 * Output:  two-dimensional Integer Array
 *
 * Example: int[] nums = {1, 2, 3, 4, 5, 6};
 *          ArrayPairs.compute(nums)  =>    
 *          {{1,2}, {3,4}, {5,6}}
 *
 * Example: int[] nums2 = {1, 2, 3, 4, 5};
 *          ArrayPairs.compute(nums2)  =>    
 *          {{1,2}, {3,4}, {5, -1}}
 */

class ArrayPairs {

  private static int indexTemp = 0;
  
  public static int[][] compute(int[] arr) {
      int temp = arr.length % 2 == 0 ? arr.length/2 : arr.length/2+1;
      
      int[][] result= new int[temp][2];
      computeHelper(arr, 0, result);
      return result;

  }

  public static void computeHelper(int[] arr, int index, int[][] result) {
        if(index > arr.length-1 ){
            
            return;
        }
      result[indexTemp][0] = arr[index++];
      if(index == arr.length){
        result[indexTemp++][1] = -1;
          
      }
      else{
        result[indexTemp++][1] = arr[index++];
      }
      computeHelper(arr, index, result);
  }
}

/*
 * 2e. Flatten a two dimensional integer array using Helper Method of Recursion
 *
 * Input:   two-dimensional Integer Array
 * Output:  Array of Integers
 *
 * Example: int matrix[][]= {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
 *          Flatten.compute(matrix) => 
 *          {1, 2, 3, 4, 5, 6, 7, 8, 9}
 */

class Flatten {

   private static int[] result;
    
  public static int[] compute(int[][] matrix) {
    int colLength = matrix.length;    
    int rowLength = matrix[0].length;
    int resultLength = colLength * rowLength;
    result = new int[resultLength];
    computeHelper(matrix, 0, 0, result);
    return result;
  }

  public static void computeHelper(int[][] matrix, int subIndex, int resultIndex, int[] result) {
    if(subIndex == matrix.length){
        return;
    }
      
      for (int num: matrix[subIndex]) {
          result[resultIndex] = num;
          resultIndex++;    
      }
      computeHelper(matrix, subIndex+1, resultIndex, result);
  }
}

/*
 * 2f. Given a base and an exponent, create a method to find the power using
 *     Helper Method Recursion
 *
 * Input:   Two Integers, base and exponent
 * Output:  Integer
 *
 * Example: Power.compute(3, 4) => 81
 */

 /*
 
 
 */
class Power {

  private static int result =1;
  private static int bTemp;
  public static int compute(int a, int b) {
        bTemp = b;
        result = computeHelper(a, 0, result);
      return result;
  }

  public static int computeHelper(int a, int b, int result) {
    if(b == bTemp) {
        return result;
    } else {
        result *= a;
        return computeHelper(a, b+1, result);
    }     
  }
}

/*
 * 2g. Merge two sorted arrays using the Helper Method Recursion
 * 
 * Input:   Two Integer Arrays, both sorted
 * Output:  Integer Array, sorted
 *
 * Example: int[] nums1 = {1, 4, 7};
 *          int[] nums2 = {2, 3, 6, 9};
 *
 *          Merge.compute(nums1, nums2) => 
 *          { 1, 2, 3, 4, 6, 7, 9 }
 */

class Merge {
    private static int rst[];
    private static int indexArr1, indexArr2, resultIdx;	
  public static int[] compute(int[] arr1, int[] arr2) {
    indexArr1 = arr1.length;
    indexArr2 = arr2.length;
    resultIdx = indexArr1 + indexArr2;
    rst = new int[resultIdx];
    
      computeHelper(arr1, 0, arr2, 0, rst, 0);
    return rst;
  }

  public static void computeHelper(int[] arr1, int index1, int[] arr2, int index2, int[] result, int resultIndex) {
      if(resultIndex == resultIdx){
          return;
      }
      if((index2 >= indexArr2) ||((index1 < indexArr1) && (arr1[index1] < arr2[index2]))){
          rst[resultIndex] = arr1[index1];
          resultIndex++;
          index1++;
      }
      else{
          rst[resultIndex] = arr2[index2];
          resultIndex++;
          index2++;
      }
      computeHelper(arr1, index1, arr2, index2, result, resultIndex);
  }
}


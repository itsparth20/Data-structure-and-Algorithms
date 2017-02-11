/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author itspa
 */

/*
Given an array of integers and a number K, find the Kth largest value in the array.

Input: Array of integers and an Integer
Output: Integer
Example
Input: [3, 1, 6, 4, 9, 8], 3     =>	Output: 6
Input: [1, 9, 5, 3], 1		=>	Output: 9
Constraints
Time Complexity: Average O(N)
Auxiliary Space Complexity: Average O(log(N))

*/
public class KthLargestElement {
    private static int k;
    private static int kthLargest;
    private static boolean foundKthLargest;
    
    public static void main(String[] args){
        int arr[] = {3, 1, 6, 4, 9, 8};
        k = 5;
        foundKthLargest = false;
        findKthLargest(arr);
    }

    private static void findKthLargest(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        sortArr(arr, l, r);       
    }

    private static void sortArr(int[] arr, int l, int r) {
        if(l<r){
            int pivot=0;
            if(foundKthLargest==false){
                pivot = partition(arr,l,r);
            
                if(k == arr.length-pivot){
                    foundKthLargest = true;
                    System.out.println(arr[pivot]);
                }
            }
            if(foundKthLargest==false){
                if(k < arr.length-pivot){
                    sortArr(arr, pivot+1, r);
                }else{
                    sortArr(arr, l, pivot-1);
                }
                
            }            
        }
        if(l == r && r == arr.length-k){
            foundKthLargest = true;
            System.out.println(arr[l]);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int mid = l-1;
        int low = l;
        int pivot = arr[r];
        
        for(int i = low; i<r; i++){
            if(pivot > arr[i]){
                mid++;
                int temp = arr[mid];
                arr[mid] = arr[i];
                arr[i]=temp;
            }
        }
        
        int temp = arr[mid+1];
        arr[mid+1] = arr[r];
        arr[r] = temp;
        return mid+1;
    }
}

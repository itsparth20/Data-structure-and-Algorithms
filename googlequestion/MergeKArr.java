/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MergeKSortedArray;

/**
 *
 * @author itspa
 */
public class MergeKArr {
    public static void main(String[] args){
        int k = 3, n=4;
        int arr[][] = {{1,2,5,7}, {2,4,6,8}, {0,9,10,11}};
        int newArr[] = new int[k*n]; 
        int t = 0;
        for(int i = 0; i<k; i++){
            for(int j = 0; j<n; j++){
                newArr[t] = arr[i][j];
                t++;
            }
        }
        
        printList(Mergesort1.compute(newArr));
    }
    private static void printList(int[] result){
    System.out.print("[ ");
    for(int i : result){
      System.out.print(i + " ");
    }
    System.out.print("]");
  }
}

class Mergesort1{
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
// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
class MyCode {
  public static void main (String[] args) {
    System.out.println("Hello Java");
    String s = "";
    s += 'b';
//     System.out.println(s);
    int[] arr = {2, 4, 11, 5, 8};
    int target = 9;
    
    int[] arr1 = {11,8,5,4,2};
    int target1 = 9;
    
    int[] indexArr = getIndexs(arr, target);
    System.out.println(indexArr[0]);
    System.out.println(indexArr[1]);
    
    int[] indexArr1 = indexs(arr1, target1);
    System.out.println(indexArr1[0]);
    System.out.println(indexArr1[1]);
  }
  public static int[] getIndexs(int[] arr, int target){
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++){
        int temp = target - arr[i];
        if(map.containsKey(temp)){
            int[] indexArr = {i, map.get(temp)};
            return indexArr;
        }
        map.put(arr[i], i);        
    }
    int[] indexArr = {-1, -1};
    return indexArr;
}
  
  
public static int[] indexs(int[] arr, int target){
    int first = 0;
    int last = arr.length-1;
    while(first < last){
        int temp = arr[first] + arr[last];
        if (temp == target){
            int[] indexArr = {first, last};
            return indexArr;
        }
        else if(temp > target){
            first++;
        }
        else{
            last--;
        }    
    }
    int[] indexArr = {-1, -1};
    return indexArr;
}
}


/* 
Your last Python code is saved below:
java

 */
package practiceProblem.GeeksforGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Question: Convert an array to reduced form
 * 
 * Given an array with n distinct elements, convert the given array to a reduced form where all elements are in range from 0 to n-1. The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second smallest element, … n-1 is placed for largest element.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N, where N is the size of array.
The second line of each test case contains N input arr[i].

Output:

Print the reduced form of the array.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ arr[i] ≤ 1000

Example:

Input:
2
3
10 40 20
5
5 10 40 30 20

Output:
0 2 1
0 1 4 3 2
 */

public class ConvertAnArrayToReducedForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,40,20};
		int arr1[] = {5, 10, 40, 30, 20};
		System.out.println(Arrays.toString(reduceForm(arr)));
		System.out.println(Arrays.toString(reduceForm(arr1)));
	}
	
	public static int[] reduceForm(int[] arr){
		int[] output = new int[arr.length];
		int[] temp = arr.clone();
		Arrays.sort(temp);
		int count = 0;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i : temp)
			map.put(i, count++);
		
		for(int i = 0; i < arr.length; i++)
			output[i] = map.get(arr[i]);
		
		return output;
	}

}

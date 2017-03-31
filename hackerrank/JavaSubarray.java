package practiceProblem;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-negative-subarray

/*
We define the following:

A subarray of an -element array is an array composed from a contiguous block of the original array's elements. For example, if , then the subarrays are , , , , , and . Something like  would not be a subarray as it's not a contiguous subsection of the original array.
The sum of an array is the total sum of its elements.
An array's sum is negative if the total sum of its elements is negative.
An array's sum is positive if the total sum of its elements is positive.
Given an array of  integers, find and print its number of negative subarrays on a new line.

Input Format

The first line contains a single integer, , denoting the length of array . 
The second line contains  space-separated integers describing each respective element, , in array .

Sample Input

5
1 -2 4 -5 1
Sample Output

9
 */

public class JavaSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,-2, 4, -5,1};
		int count = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++ ){
			sum = 0;
			for(int j=i; j<arr.length; j++){
				sum += arr[j];
				if(sum<0)
					count++;
			}
				
			
		}
		System.out.println(count);
		
	}

}

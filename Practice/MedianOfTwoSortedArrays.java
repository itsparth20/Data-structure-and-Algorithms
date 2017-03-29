package practiceProblem;
/*
Median of Two Sorted Arrays
Given two sorted array of integers, determine the median of the combined sorted array.

Input: Two Arrays of Integers
Output: Float
Example
Input:  	[1, 12, 15, 26, 38], [2, 13, 17, 30, 45]
Output:	16 
(because the median of [1, 2, 12, 13, 15, 17, 26, 30, 38, 45] equals 16)

 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1, 12, 15, 26, 38};
		int[] arr2 = {2, 13, 17, 30, 15};
		
		System.out.println(medianOfArrays(arr1,arr2));
	}

	private static int medianOfArrays(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int totalLenght = arr1.length + arr2.length;
		int indexOne = 0, indexTwo = 0, medianIndex = 0, medianValueOne = 0, medianValueTwo = 0;
		
		while(medianIndex <= totalLenght/2){
			if(arr1[indexOne] < arr2[indexTwo]){				
				medianValueTwo = medianValueOne;
				medianValueOne = arr1[indexOne];
				indexOne++;
			}else{				
				medianValueTwo = medianValueOne;
				medianValueOne = arr2[indexTwo];
				indexTwo++;
			}
			medianIndex++;
		}
		
		if(totalLenght % 2 == 0){
			return (medianValueOne+medianValueTwo)/2; 
		}
		return medianValueOne;
	}

}

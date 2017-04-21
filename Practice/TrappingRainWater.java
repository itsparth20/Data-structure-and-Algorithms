package practiceProblem;

/*
 * Trapping Rain Water
Given an array of integers representing the elevations of rocks, determine the total amount of water that can be trapped between rocks.

Input: 		Array of integers
Output: 	Integer

Input: [3, 0, 2, 0, 4]      
Output: 7

 */
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 0, 2, 0, 4};
		
		System.out.println(totalWaterTrapped(arr));
	}

	private static int totalWaterTrapped(int[] arr) {
		// TODO Auto-generated method stub
		int count = 0, leftMax = arr[0], rightMax = arr[arr.length-1];
		int[] leftWall = new int[arr.length];
		int[] rigthWall = new int[arr.length];
		leftWall[0] = 0;
		rigthWall[arr.length-1] = 0;
		
		for(int i = 1; i<arr.length; i++){
			leftWall[i] = Math.max(arr[i-1], leftMax);
			leftMax = Math.max(arr[i], leftMax);
		}
		
		
		for(int i = arr.length-2; i>=0; i--){
			rigthWall[i] = Math.max(arr[i+1], rightMax);
			rightMax = Math.max(arr[i], rightMax);
		}
//		System.out.println(Arrays.toString(leftWall));
//		System.out.println(Arrays.toString(rigthWall));
		
		for(int i = 0; i < arr.length; i++){
			int min = Math.min(leftWall[i], rigthWall[i]);
			if(min-arr[i] > 0){
				count += min-arr[i]; 
			}
		}
		return count;
	}

}

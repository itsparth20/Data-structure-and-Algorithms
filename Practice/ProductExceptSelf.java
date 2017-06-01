package practiceProblem;

import java.util.Arrays;

/*
 * You have an array nums. We determine two functions to perform on nums. In both cases, n is the length of nums:

fi(nums) = nums[0] · nums[1] · ... · nums[i - 1] · nums[i + 1] · ... · nums[n - 1]. (In other words, fi(nums) is the product of all array elements except the ithf.)
g(nums) = f0(nums) + f1(nums) + ... + fn-1(nums).
Using these two functions, calculate all values of f modulo the given m. Take these new values and add them together to get g. You should return the value of g modulo the given m.

Example

For nums = [1, 2, 3, 4] and m = 12, the output should be
productExceptSelf(nums, m) = 2.

The array of the values of f is: [24, 12, 8, 6]. If we take all the elements modulo m, we get:
[0, 0, 8, 6]. The sum of those values is 8 + 6 = 14, making the answer 14 % 12 = 2.
 */
public class ProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		int[] nums2 = {27, 37, 47, 30, 17, 6, 20, 17, 21, 43, 5, 49, 49, 50, 20, 42, 45, 1, 22, 44};		
		int m2 = 40;
		int m = 12;
		System.out.println(productExceptSelf(nums, m));
		System.out.println(productExceptSelf(nums2, m2));		
	}

	private static int productExceptSelf(int[] nums, int m) {
		int len = nums.length;
		int left[] = new int[len];
		int right[] = new int[len];
		int multi[] = new int[len];
		int answer = 0;
		if (len > 0) {
			left[0] = 1;
			right[len-1] = 1;
		}
		
		for (int i = 1, j = len - 2; i < len; i++, j--) {
			left[i] = left[i-1]*nums[i-1];
			right[j] = right[j+1]*nums[j+1];
		}
		
		for(int i = 0; i < len; i++){			
			int temp = left[i]*right[i];
			multi[i] = temp;
			answer += (temp%m);
		}		
		return answer%m;
	}

}

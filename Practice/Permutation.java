package practiceProblem;

/*
 * Permutation of String and Permutation of Arrays
 */
import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String[] arr = {"a", "b", "c"};
		permutationOfString(s, 0, s.length()-1);
		permutationOfArr(arr, 0, arr.length-1);
	}

	private static void permutationOfArr(String[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if(left == right){
			System.out.println(Arrays.toString(arr));
		}else{
			for(int i = left; i<=right; i++){
				String[] swapArr = swapArr(arr, left, i);				
				permutationOfArr(swapArr, left+1, right);
			}
		}
	}

	private static String[] swapArr(String[] orignalArr, int left, int right) {
		// TODO Auto-generated method stub
		String[] arr = orignalArr.clone();
		String temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;		
		return arr;
	}

	private static void permutationOfString(String s, int left, int right) {
		if(left == right){
			System.out.println(s);
		}else{
			for(int i = left; i<=right; i++){
				String swapStr = swap(s, left, i);				
				permutationOfString(swapStr, left+1, right);
			}
		}		
	}

	private static String swap(String s, int left, int right) {
		char[] arr = s.toCharArray();
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;		
		return String.valueOf(arr);
	}

}

package cerner;
import static java.lang.Math.abs;

public class JollyJump {

	public static void main(String[] args) {
		int[] a = {1 ,4, 2, 3};
		int[] b = {1 ,4 ,2 ,-1 ,6 };
		System.out.println(jolly(a,4));
		System.out.println(jolly(b,5));
	}
	
	public static String jolly(int[] arr, int n){
		boolean[] booleanArr = new boolean[n];		
		for(int i = 0; i < n-1; i++){
			int val = abs(arr[i] - arr[i+1]);
			if(val == 0 || val > n || booleanArr[val]) return "Not Jolly";
			booleanArr[val] = true;
		}
		return "Jolly";
	}
}

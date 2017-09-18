package leetcode.outco;

public class Find0inBooleanMatrix {
	public static void main(String[] args){
		int[][] arr = {{0, 0, 1},
				{0,1, 1}};
		int[][] arr1 = {{0, 0, 0},
				{0,1, 1},{0,1,1}
		};
		System.out.println(solution(arr));
		System.out.println(solution(arr1));
	}
	
	public static int solution(int[][] arr){
		int count = 0, len = arr.length;
		int j = len-1;
		for(int i = 0; i < len; i++){
			while(arr[i][j] == 1){
				j--;
			}
			count += j+1;
		}
		
		return count;
	}
}

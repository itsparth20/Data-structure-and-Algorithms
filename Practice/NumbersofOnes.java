package leetcode.outco;

public class NumbersofOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,0,0,1};
		System.out.println(numberOfOnes(arr));
	}
	
	public static int numberOfOnes(int[] arr){
		int l = 0;
		int r = arr.length -1;
		int m;
		int len = arr.length;
		
		while(l <= r){
			m = (l+r)/2;
			if(arr[m] > arr[m-1]){
				return len-m;				
			}else if(arr[m] == 1){
				r = m -1;
			}else{
				l = m+1;
			}
		}
		return -1;
		
	}

}

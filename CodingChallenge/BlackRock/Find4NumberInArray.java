package practiceProblem;

import java.util.HashMap;
import java.util.Map;

public class Find4NumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,4,2,3};
		
		sum(a);
	}
	
	public static void sum(int[] arr){
		Map<Integer, String> map = new HashMap<Integer,String>();
		
		for(int i = 0; i< arr.length-1; i++){
			for(int j = i+1; j< arr.length; j++){
				int sum = arr[i]+arr[j];
				if(map.containsKey(sum)){
					System.out.print(map.get(sum));
					System.out.print(" = "+ arr[i]+" + "+ arr[j]);
					return;
				}
				String strSum = String.valueOf(arr[i]) + " + " + String.valueOf(arr[j]);
				map.put(sum, strSum);
			}
		}
	}

}

package fidessa;

import java.util.ArrayList;

public class Airport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {900, 940, 950, 1100, 1500, 1800};
		int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
		int flight = 6;		
		System.out.println(findMinGates(arr, dep, flight));
		
	}
	
	static int findMinGates(int[] arr, int[] dep, int flight){
		int max = 0;
		if(flight==0) return max;
		if(flight==1) return 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(dep[0]);
		
		for(int i = 1, j = 0; i < flight; i++, j = 0){
			int arrival = arr[i];
			while(list.size() != 0 && j < list.size()){
				if(arrival > list.get(j)){
					list.remove(j);
				}
				j++;
			}
			list.add(dep[i]);
			max = Math.max(list.size(), max);
		}
		
		return max;
	}

}



import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5};
		int[] b = {1, 1, 7, 5};
		
		System.out.println(getMap(a,b));
	}
	
	public static Map<Integer, Integer> getMap(int[] a, int[]b){
		Map<Integer, Integer> map = new HashMap<>();
		int alen = a.length;
		int blen = b.length;
		int len = alen > blen ? alen : blen;
		
		for(int i = 0; i < len; i++){
			if(i < alen){
				map.putIfAbsent(a[i], 0);
				map.put(a[i], map.get(a[i])+1);
			}
			if(i < blen){
				map.putIfAbsent(b[i], 0);
				map.put(b[i], map.get(b[i])+1);
			}
		}
		return map;
	}

}

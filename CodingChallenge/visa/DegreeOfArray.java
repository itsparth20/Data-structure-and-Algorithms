package visa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Find the Degree of the program
 * For Example the arr [1,4,4,1,3] has a degree of 2 because 1 and 4 repeat 2 maximum 2 time. There are two possible subarrays with this degree
 *  is [1,4,4,1] and [4,4]. Our answer is the length of the smallest subarrar, which is 2
 */

public class DegreeOfArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 2, 1 };

		System.out.println(degreeOfArray(arr));
	}

	public static int degreeOfArray(int[] arr){
        Map<Integer, VO> map = new HashMap<>();
        int max = 0;
        int count = 0;
        for(int i : arr){
        	VO vo = new VO(i);
        	         	
            map.putIfAbsent(i,vo);            
            VO val = map.get(i);            
            val.endIndex = count;
            if(val.occur == 0)
            	val.startIndex = count;
            val.occur += 1;
            map.put(i, val);
            max = max < val.occur ? val.occur : max;
            count++;
        }
        //Print key, startindex, endIndex, occure
//        map.forEach((k, v) -> System.out.println(k +" " + v));
        //Print Max
//        System.out.println(max);
        
        int minRange = Integer.MAX_VALUE;
        for(Integer s : map.keySet()){
        	VO v = map.get(s);
        	if(v.occur == max){        		
        		minRange = minRange > (v.endIndex - v.startIndex + 1) ? (v.endIndex - v.startIndex + 1) : minRange;  
        	}
        }
        
        return minRange;
    }

}

class VO {
	public int val;
	public int startIndex;
	public int endIndex;
	public int occur;
	public VO(int val) {
		this.val = val;

	}
	@Override
	public String toString() {
		return String.format(startIndex + " " + endIndex + " " + occur);
	}

}

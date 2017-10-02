package exam.com.test;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Solution {

	public static void main(String[] args) {
		int[] arr3 = new int[61];
		int k = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				if(i < 61)
					arr3[i++] = Integer.valueOf(sCurrentLine);
				else
					k = Integer.valueOf(sCurrentLine);
				
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("Hey");
//		int[] arr = {1,2,3};
//		int[] arr2 = {3,1,2,1};
		//maxLength(arr2, 4);
		maxLength(arr3, k);
		System.out.println(sizeLength);
	}
	private static final String FILENAME = "/Users/prince.patel/Downloads/input002.txt";
	static int max = 0;
    static int sizeLength = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    static int maxLength(int[] a, int k) {
        helper(a, k, 0, 0, 0);
        return sizeLength;
    }

    static void helper(int[] a, int k, int len, int index, int size){
        if(len > k){
            return;
        }
        if(len <= k && sizeLength <= size){
            max = Math.max(max,len);
            sizeLength = Math.max(size,sizeLength);
        }
        
        if(index < a.length){
            helper(a, k, len+a[index], index+1, size+1);
            helper(a, k, len, index+1, size);
        }
    }


}

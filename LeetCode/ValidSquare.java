package practiceProblem.leetcode;
/*
 * 593. Valid Square
 * 
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * 
 * Example:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * 
 * 
 */
import java.util.Arrays;
import java.util.OptionalLong;

public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {0,0};
		int[] p2 = {0,1};
		int[] p3 = {1,1};
		int[] p4 = {1,0};
		
		System.out.println(validSquare(p1, p2, p3, p4));
		
	}

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		long[] length = {findLength(p1, p2), findLength(p2, p3), findLength(p3, p4), findLength(p4, p1), findLength(p1, p3), findLength(p2, p4)};
		OptionalLong max = Arrays.stream(length).max();
		
		int maxOccure = 0; 
		long secondMax = 0;
		for(int i = 0 ; i < length.length; i++){
			if(length[i] == max.getAsLong()) maxOccure++;
			else secondMax = Math.max(secondMax, length[i]);
		}
		
		if(maxOccure > 2) return false;
		
		for(long i : length){
			if(i != max.getAsLong() && i != secondMax) return false;
		}
		return true;
	}

	private static long findLength(int[] p1, int[] p2){
		return (long)(Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2) ); 
	}
}

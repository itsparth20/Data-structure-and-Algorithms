package geeksforGeeks;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inputArray[] = {100, 54, 355, 102, 43, 10, 287, 005};
	    final int RADIX = 10;
	 
	    ArrayList<Integer> bucketsArray[] = new ArrayList[RADIX];
	    for (int count = 0; count < bucketsArray.length; count++) {
	      bucketsArray[count] = new ArrayList<>();
	    }
	 
	    boolean maxDigitsLengthReached = false;
	    int temp = -1, placeValue = 1;
	    while (!maxDigitsLengthReached) {
	      maxDigitsLengthReached = true;
	      for (Integer element : inputArray) {
	        temp = element / placeValue;
	        bucketsArray[temp % RADIX].add(element);
	        if (maxDigitsLengthReached && temp > 0) {
	          maxDigitsLengthReached = false;
	        }
	      }
	      int a = 0;
	      for (int b = 0; b < RADIX; b++) {
	        for (Integer i : bucketsArray[b]) {
	          inputArray[a++] = i;
	        }
	        bucketsArray[b].clear();
	      }
	      placeValue = placeValue * RADIX;
	    }
	    Arrays.stream(inputArray).forEach(System.out::println);
	  }

}

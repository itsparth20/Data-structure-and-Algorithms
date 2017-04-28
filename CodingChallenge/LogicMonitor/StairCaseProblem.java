package LogicMonitor;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StairCaseProblem {
	public static void main(String[] args) {
		StairCase(6);
		int arr[] = {1,2,3};		
		System.out.println(IntStream.of(arr).sum());
	}

	static void StairCase(int n) {
		int i = n - 1;
		int temp = n;
		while (temp > 0) {
            
			for (int j = 0; j < temp-1; j++) {
				System.out.print(" ");
			}
			for (int k = temp; k <= n; k++) {
				System.out.print("#");
			}
			System.out.println();
			temp--;
		}
	}
}

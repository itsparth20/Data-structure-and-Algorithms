import java.util.Arrays;

//Esurance Hackerrank Test

/*Question
Find the pair where sum of that pair is equal to k and pair value should be unique
*/
class Esurance{

	public static void main(String[] args) {

		int[] b = { 6, 6, 6, 6, 3, 5, 1 };
		System.out.println(solution(b, 12));
		
	}

	public static int solution(int[] a, long k) {
		Arrays.sort(a);
		int count = 0;
		int i = 0, j = a.length - 1;
		while (i < j) {
			if (Long.valueOf(a[i]) + Long.valueOf(a[j]) == k) {
				count++;

				i++;
				while (i < a.length && i > 0 && a[i] == a[i - 1]) {
					i++;
				}

				j--;
				while (j < a.length && j > 0 && a[j] == a[j + 1]) {
					j--;
				}
			} else if (Long.valueOf(a[i]) + Long.valueOf(a[j]) < k) {
				i++;
			} else {
				j--;
			}
		}

		return count;
	}
}

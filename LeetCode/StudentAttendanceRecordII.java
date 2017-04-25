/*
 * 552. Student Attendance Record II
 * 
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
 */
package practiceProblem.leetcode;

public class StudentAttendanceRecordII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkRecord(2);
		System.out.println(count);
	}

	static int count = 0;

	private static int checkRecord(int n) {
		helper(n, 0, false, false, 0);
		return count;
	}

	static void helper(int n, int A, boolean L, boolean lL, int total) {
		if (A == 2)
			return;
		
		if (total == n) {
			count = (count + 1) % 1000000007;
			return;
		}		
		
		helper(n, A, false, false, total + 1);
		helper(n, A + 1, false, false, total + 1);
		if (!(L && lL)) {
			if (L == false) {
				helper(n, A, true, false, total + 1);
			} else {
				helper(n, A, true, true, total + 1);
			}

		}

	}
}

package practiceProblem.leetcode;
/*
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */

public class StudentAttendanceRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkRecord("LPPLL"));
	}

	private static boolean checkRecord(String s) {
		int A = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				A--;
				if (A == -1) 
					return false;				
			} else if (s.charAt(i) == 'L') {
				if (i != 0 && i != 1 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L')
					return false;
			}
		}
		return true;
		
		//This one will take more time then above solution.
		//return !s.matches(".*LLL.*|.*A.*A.*");
	}

}

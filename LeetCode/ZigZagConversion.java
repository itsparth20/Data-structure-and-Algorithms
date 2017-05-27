package practiceProblem.leetcode;
/*
 * 6. ZigZag Conversion
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

More Description: https://leetcode.com/problems/zigzag-conversion/#/description
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("AB", 1));
	}

	public static String convert(String s, int numRows) {
		boolean down = true;
		int downCount = 0;
		StringBuilder[] list = new StringBuilder[numRows];
		for (int i = 0; i < list.length; i++)
			list[i] = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			list[downCount].append(s.charAt(i));
			if (numRows != 1) {
				if (downCount == 0)
					down = true;
				if (downCount == numRows - 1)
					down = false;
				downCount = down ? downCount + 1 : downCount - 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length; i++)
			sb.append(list[i].toString());
		return sb.toString();
	}
}

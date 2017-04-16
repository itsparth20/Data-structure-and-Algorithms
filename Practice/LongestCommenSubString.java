package practiceProblem;

public class LongestCommenSubString {
	public static void main(String[] args) {
		String str1 = "121abcd56";
		String str2 = "5621abcd";

		findLongestSubString(str1.toCharArray(), str2.toCharArray());

	}

	private static void findLongestSubString(char[] str1, char[] str2) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[str1.length + 1][str2.length + 1];
		int max = 0;
		for (int i = 0; i < str1.length + 1; i++) {
			for (int j = 0; j < str2.length + 1; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
					continue;
				}
				if (str1[i - 1] == str2[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
					max = matrix[i][j] > max ? matrix[i][j] : max;
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println("Max substring length = " + max);
		boolean found = false;
		StringBuffer sb = new StringBuffer();
		for (int i = str1.length; i >= 0; i--) {
			for (int j = str2.length; j >= 0; j--) {
				if (matrix[i][j] == max) {
					found = true;
					while (matrix[i][j] != 0) {
						sb.append(str1[i - 1]);
						i--;
						j--;
					}
					break;
				}
			}
			if(found){
				break;
			}
		}
		System.out.println("Substring is : "+sb.reverse().toString());
	}
}

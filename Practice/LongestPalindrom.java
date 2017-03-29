package practiceProblem;

/*
Longest Palindrome
Given a string, determine the longest substring that is a palindrome 

Input: A string
Output: A string which is the longest palindrome
Example
Input: ”mydadlikestodriveracecars”
Output: “racecar”
*/

public class LongestPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mydadlikestodriveracecars";
		System.out.println(longestPalindrom(s));
	}

	private static int longestPalindrom(String s) {
		// TODO Auto-generated method stub
		int max = 0;
		String palindrom = "";
		for(int i = 0; i< s.length(); i++){
			
			//Odd
			int index = 1;
			while(i-index >= 0 && i+index < s.length()){
				if(s.charAt(i-index) == s.charAt(i+index)){					
					if(max < (index*2+1) ){
						max = index*2+1;
						palindrom = s.substring(i-index, i+index+1);				
					}
					index++;
				}else
					break;
			}
						
			//Even
			int leftIndex = i;
			int rightIndex = i+1;			
			while(leftIndex >= 0 && rightIndex < s.length()){
				if(s.charAt(leftIndex) == s.charAt(rightIndex)){					
					if(max < (rightIndex - leftIndex + 1) ){
						max = rightIndex - leftIndex + 1;
						palindrom = s.substring(leftIndex, rightIndex+1);
					}
					leftIndex--;
					rightIndex++;
				}else
					break;
			}
		}
		System.out.println(palindrom);
		return max;
	}

}

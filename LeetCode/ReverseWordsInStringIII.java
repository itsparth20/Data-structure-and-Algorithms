package practiceProblem.leetcode;

/*
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description
 * 
 * 557. Reverse Words in a String III
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseWordsInStringIII {

	public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        String s= "Hello Java";
        System.out.println(reverseWords(s));
    }
    
	public static String reverseWords(String s) {
        if(s == null || s.length() < 2)
            return s;
        char[] arr = s.toCharArray();
        int first = 0, end = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == ' ' || i == arr.length-1){
            	if(i == arr.length-1)
            		end = i;
                while(first < end){                    
                    char temp = arr[first];
                    arr[first] = arr[end];
                    arr[end] = temp;
                    first++;
                    end--;
                }
                
                first = i+1;
            }
            end = i;
        }        
        return new String(arr);
    }

}

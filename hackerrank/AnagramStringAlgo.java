package hackerrank;
/*
 * Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books.
 * He chooses strings S1 and S2 in such a way that |len(s1)-len(s2)| <= 1.
 * 
 * Your task is to help him find the minimum number of characters of the first string he needs to change to enable him to make it an anagram of the second string.
 * 
 * Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.

Input Format

The first line will contain an integer, T representing the number of test cases. Each test case will contain a string having length len(s1)+len(s2) , which will be concatenation of both the strings described above in the problem.The given string will contain only characters from a to z

Output Format

An integer corresponding to each test case is printed in a different line, i.e. the number of changes required for each test case. Print  if it is not possible.

Sample Input

6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx
Sample Output

3
1
-1
2
0
1
Explanation

Test Case #01: We have to replace all three characters from the first string to make both of strings anagram. Here, 
S1 = aaa and S2 = bbb  So the solution is to replace all character 'a' in string a with character 'b'

More information @ https://www.hackerrank.com/challenges/anagram


 */
import java.util.HashMap;
import java.util.Scanner;

public class AnagramStringAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numTry = sc.nextInt();
		for (int i = 0; i < numTry; i++){
			System.out.println(numberOfChangesNeeded(sc.next().trim()));	
		}
		sc.close();
	}
	
	private static int numberOfChangesNeeded(String str){
		int change = 0;
		if(str.length()%2 != 0) return -1;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < str.length()/2; i++){
			map.putIfAbsent(str.charAt(i), 0);
			map.put(str.charAt(i), map.get(str.charAt(i))+1);
		}
		
		for(int i = str.length()/2; i < str.length(); i++){
			if(!map.containsKey(str.charAt(i))) change++;
			
			else if(map.get(str.charAt(i))> 0) {				
				map.put(str.charAt(i), map.get(str.charAt(i))-1);
			}
			else{
				change++;
			}
		}
		
		return change;
	}

}

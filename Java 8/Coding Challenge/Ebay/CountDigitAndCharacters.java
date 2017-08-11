package tries;

import java.util.Scanner;
/*
 * Input: String
 * Output: First Line - number of digits in String
 * Second Line - number of English letters in String
 */
public class CountDigitAndCharacters {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		
		int digit = 0, alpha = 0;
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) >= 48 && input.charAt(i) <= 57) 
				digit++;
			else if(( input.charAt(i) >= 65 && input.charAt(i) <= 90) || ( input.charAt(i) >= 97 && input.charAt(i) <= 122))
				alpha++;				
		}
		
		System.out.println(digit);
		System.out.println(alpha);
		
		usingStreamApi(input);
	}

	private static void usingStreamApi(String input) {
		// TODO Auto-generated method stub
		System.out.println(input.chars().filter(c -> c >= 48 && c <= 57).count());
		System.out.println(input.chars().filter(c -> ( c >= 65 && c <= 90) || ( c >= 97 && c <= 122)).count());
	}
	
}

package fidessa;

import java.util.Stack;

public class MatchingPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABba";
		System.out.println(findMatchingPair(str));
		
		String str1 = "ABbCca";
		System.out.println(findMatchingPair(str1));
		
	}
	
	static int findMatchingPair(String input){
		int match = -1, index = 0;
		Stack<Character> lifo = new Stack<Character>();
		if(input.charAt(index) < 'A' || input.charAt(index) > 'Z') return -1;
		while(index < input.length() ){
			if(input.charAt(index) >= 'A' && input.charAt(index) <= 'Z')
				lifo.push(input.charAt(index));
			else{				
				if(!lifo.isEmpty() && lifo.pop() == input.charAt(index) - 32) match = index;
				else return match;
			}		
			index++;
		}
		if(!lifo.isEmpty()) return match;			
		return index-1;
	}
}

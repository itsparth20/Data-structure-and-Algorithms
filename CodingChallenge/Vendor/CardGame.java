
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String A, String B) {
        // write your code in Java SE 8
        char[] card1 = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};    
        List<Character> card = new ArrayList<>(Arrays.asList('2','3','4','5','6','7','8','9','T','J','Q','K','A'));
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            char chA = A.charAt(i);
            char chB = B.charAt(i);
            if(card.indexOf(chA) > card.indexOf(chB)){
                count++;    
            }
        }
        return count;
    }

}




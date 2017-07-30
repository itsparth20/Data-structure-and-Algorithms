package tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class RemoveSpecificCharacterFromStringUsingStreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeChar("Parth", 'P');
	}
	
	public static void removeChar(String str, char ch){
		List<Character> chList = str.chars().mapToObj(c -> (char)c).filter(c -> c != ch).collect(Collectors.toList());
		chList.forEach(System.out::println);
	}

}

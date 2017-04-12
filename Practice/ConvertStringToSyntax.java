package practiceProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class convertStringToSyntax {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create dictionery 
		Set<String> dict = new HashSet<String>();
		dict.add("who");
		dict.add("is");
		dict.add("president");
		dict.add("of");
		dict.add("the");
		dict.add("usa");
		dict.add("pre");
		dict.add("side");
		dict.add("entof");
		
		//input string
		String input = "whoispresidentoftheUSA";
		
		//create object
		convertStringToSyntax obj = new convertStringToSyntax();
		
		//create map so we can save input string and syntax - that we can make using that input string.
		HashMap<String,String> map = new HashMap<String,String>(); 
		System.out.println(obj.getStringWithSpace(input.toLowerCase(), map, dict));
		
	}

	String getStringWithSpace(String input, HashMap<String,String> map, Set<String> dict){
		//if dictionary contain input string then return that 
		if(dict.contains(input)){
			return input;
		}
		//if map contain input key then return syntax that we can make using that input.
		else if(map.containsKey(input)){
			return map.get(input);			
		}else{
			//loop through every character of the input.
			for(int i = 1; i < input.length(); i++){
				//take prefix of the input (left parth of the input).
				String leftSide = input.substring(0, i);
				//if leftpart contain in dictionary then check for rest of the string
				if(dict.contains(leftSide)){
					//take rest of the string (right part of the string)
					String rightSide = input.substring(i);
					//recursively call itself to check that can we create syntax using right part.
					String inputRightSide = getStringWithSpace(rightSide, map, dict);
					//if its is not null then we can create syntax using input string.
					if(inputRightSide != null){
						String syntax = leftSide + " " + inputRightSide;
						//we are putting this input and syntax to map so if same input come in future then we can use that same syntax.
						map.put(input, syntax);
						//return syntax;
						return syntax;
					}
				}
			}
			map.put(input, null);
			return null;
		}					
	}
}

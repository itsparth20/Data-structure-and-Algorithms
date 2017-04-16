package practiceProblem;

public class PowerOfSetOfString {
	public static void main(String[] args){
		String s = "abc";
		
		powerSet(s);
		
	}

	private static void powerSet(String s) {
		// TODO Auto-generated method stub
		helper(s, new String(""), 0);
	}

	private static void helper(String s, String string, int i) {
		// TODO Auto-generated method stub
		if(s.length() == i){
			System.out.println(string);
			return;
		}
		if(i > s.length()){
			return;
		}
		helper(s, string+s.charAt(i), i+1);
		helper(s, string, i+1);
	}
}

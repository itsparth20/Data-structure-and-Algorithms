package hackerrank;

import java.util.Arrays;
import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"*34", "+1*23", "+12", "+1**23/14"};
		
		System.out.println(Arrays.toString(prefixToPostfix(arr)));

	}

	public static String[] prefixToPostfix(String[] prefix) {
		String[] postfix = new String[prefix.length];
		int j = -1;
		for (String s1 : prefix) {
			Stack<String> stack = new Stack<String>();
			for (int i = s1.length() - 1; i >= 0; i--) {
				String s = String.valueOf(s1.charAt(i));  
				if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
					stack.push(stack.pop() + stack.pop() + s);
				else
					stack.push(s);
			}
			postfix[++j] = stack.pop();
		}
		return postfix;
	}

}

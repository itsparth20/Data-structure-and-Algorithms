package LogicMonitor;

import java.util.Stack;

public class PrefixToPostFix {
	public static void main(String[] args){
		String prefix = "-*+ABC*-DE+FG";
		
		Stack<String> st = new Stack();
		
		String t1, t2;
		
		int l = prefix.length();
		for (int i = l - 1; i >= 0; i--)
		{
			if (isOperator(prefix.charAt(i)))
			{
				t1 = st.pop();				
				t2 = st.pop();					
				t2 += prefix.charAt(i);
				st.push(t1 + t2);
				
			}
			else
			{
				t1 = "";
				t1 += prefix.charAt(i);
				st.push(t1);
			}
		}
		
		String postfix = st.pop();
		
		System.out.println(postfix);
	}
	
	public static boolean isOperator(char c)
	{
		if(c == '+' || c == '-' || c == '*' || c == '/')		//	you may add operator here
			return true;
		return false;
	}
	
	
 
}

package tries;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(2,1,3));
		SortStack obj = new SortStack();
		
		//Java 8 - Descending order
		s.sort((s1, s2) -> s1.compareTo(s2));
		
		//Java 8- Ascending order
		s.sort((s1, s2) -> s2.compareTo(s1));
		
		//Old version
		s = obj.sort(s,1);
//		System.out.println(s.peek());
	}
	
	public Stack<Integer> sort(Stack<Integer> s, int ascDes){
		Stack<Integer> s2 = new Stack<>();
		
		//while orignal stack is not empty
		while(!s.isEmpty()){
			//get peek value
			int val = s.pop();
			
			//0 means ascending sort
			if(ascDes == 0)
				while(!s2.isEmpty() && s2.peek() < val)
					s.push(s2.pop());
			//1 means descending sort
			else
				while(!s2.isEmpty() && s2.peek() > val)
					s.push(s2.pop());
			s2.push(val);
		}		
		return s2;
	}

}

package practiceProblem;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println(Arrays.toString(stack.toArray()));
		reverse(stack);
		System.out.println(Arrays.toString(stack.toArray()));
	}

	private static void reverse(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			reverse(stack);
			insertAtBottom(stack, temp);
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int temp) {
		// TODO Auto-generated method stub
		if (stack.isEmpty()) {
			stack.push(temp);
			return;
		}

		int item = stack.pop();
		insertAtBottom(stack, temp);
		stack.push(item);
	}
}

/*
150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
*/
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j + i);
            } else if (token.equals("-")) {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j - i);

            } else if (token.equals("*")) {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j * i);

            } else if (token.equals("/")) {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j / i);

            } else {
                stack.push(Integer.valueOf(token));
            }

        }
        return stack.peek();
    }
}


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class BalancedParanthesis {

    private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }  

    private BalancedParanthesis() {};

    /**
     * Returns true is parenthesis match open and close.
     * Understands [], {}, () as the brackets
     * It is clients responsibility to include only valid paranthesis as input.
     * A false could indicate that either parenthesis did not match or input including chars other than valid paranthesis
     * 
     * @param str   the input brackets
     * @return      true if paranthesis match.
     */
    public static boolean isBalanced(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }
        // odd number would always result in false
        if ((str.length() % 2) != 0) {
            return false;
        }

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (brackets.containsKey(str.charAt(i))) {
                
                stack.push(str.charAt(i));
                //System.out.println(str.charAt(i));
                
            } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
                
                return false;
            
            } 
        }
        return true;
    } 

    public static void main(String[] args) {
        
        System.out.println(isBalanced("{}([])"));
        System.out.println(isBalanced("([}])"));
        /*assertEquals(true, isBalanced("{}([])"));
        assertEquals(false,isBalanced("([}])"));
        assertEquals(true, isBalanced("([])"));
        assertEquals(true, isBalanced("()[]{}[][]"));
*/
    }
}
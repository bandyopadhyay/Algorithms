import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Easy
 *
 * 2750
 *
 * 136
 *
 * Favorite
 *
 * Share
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {


    public static void main (String[] args){

        ValidParentheses l = new ValidParentheses();
        System.out.println(l.isValid("()"));

    }
    /**
     * Algorithm
     *
     * Initialize a stack S.
     * Process each bracket of the expression one at a time.
     * If we encounter an opening bracket, we simply push it onto the stack. This means we will process it later, let us simply move onto the sub-expression ahead.
     * If we encounter a closing bracket, then we check the element on top of the stack. If the element at the top of the stack is an opening bracket of the same type, then we pop it off the stack and continue processing. Else, this implies an invalid expression.
     * In the end, if we are left with a stack still having elements, then this implies an invalid expression.
     */

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for(int i =0; i<s.length(); i++){
            if(isOpenBracket(s.charAt(i))){
                stack.push(s.charAt(i));
            } else if(isClosingBracket(s.charAt(i))){
                if(stack.isEmpty()) {
                    return false;
                }
                if(matches(stack.peek(), s.charAt(i))){
                    stack.pop();
                } else {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    private boolean matches(char peek, char charAt) {

        return  (charAt == ')' && peek == '(') || (charAt == '}' && peek == '{') || (charAt == ']' && peek == '[') ;
    }

    private boolean isClosingBracket(char charAt) {
        return (charAt == ')') || (charAt == '}') || (charAt == ']');
    }

    private boolean isOpenBracket(char charAt) {

        return (charAt == '(') || (charAt == '{') || (charAt == '[');
    }

}

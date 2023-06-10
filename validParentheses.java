import java.util.Stack;

public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> st = new Stack<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[') {
                st.push(expression.charAt(i));
            } else if (expression.charAt(i) == '}') {
                if (!st.isEmpty() && st.peek() == '{')
                    st.pop();
                else
                    return false;
            } else if (expression.charAt(i) == ']') {
                if (!st.isEmpty() && st.peek() == '[')
                    st.pop();
                else
                    return false;
            } else if (expression.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(')
                    st.pop();
                else
                    return false;
            }
        }
        // System.out.print(st.size());
        return st.isEmpty();
    }
}
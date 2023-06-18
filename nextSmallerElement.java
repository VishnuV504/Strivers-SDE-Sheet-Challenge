import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> A, int n) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty())
                ans.add(-1);
            else
                ans.add(A.get(stack.peek()));
            stack.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
}
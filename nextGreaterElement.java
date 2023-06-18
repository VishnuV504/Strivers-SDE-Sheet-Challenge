import java.util.*;
import java.io.*;

public class Solution {

    public static int[] nextGreater(int[] A, int n) {
        // Write Your code here
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = A[stack.peek()];
            stack.push(i);
        }
        return ans;
    }

}

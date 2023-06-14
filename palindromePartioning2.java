import java.util.*;
import java.io.*;

public class Solution {

    public static int palindromePartitioning(String s) {
        // Write your code here
        Integer dp2[][] = new Integer[2001][2001];
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = i; j < n; j++) {
                if (k == j)
                    dp[k][j] = true;
                else if (j - k == 1)
                    dp[k][j] = (s.charAt(k) == s.charAt(j));
                else
                    dp[k][j] = dp[k + 1][j - 1] && (s.charAt(k) == s.charAt(j));
                k++;
            }
        }
        return solve(0, 0, s, dp, dp2) - 1;
    }

    public static int solve(int start, int end, String s, boolean arr[][], Integer dp2[][]) {
        if (end >= s.length())
            return (start == end) ? 0 : 2001;
        if (dp2[start][end] != null)
            return dp2[start][end];
        int left = 2001;
        if (arr[start][end])
            left = 1 + solve(end + 1, end + 1, s, arr, dp2);
        int right = solve(start, end + 1, s, arr, dp2);
        return dp2[start][end] = Math.min(left, right);
    }
}

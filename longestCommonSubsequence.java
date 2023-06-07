
import java.util.*;

public class Solution {

    public static int lcs(String s, String t) {
        // Your code goes here
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            Arrays.fill(dp[i], -1);
        return solve(0, 0, s.length(), t.length(), s, t, dp);
    }

    public static int solve(int i, int j, int m, int n, String s, String t, int dp[][]) {
        if (i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int go = Math.max(solve(i + 1, j, m, n, s, t, dp), solve(i, j + 1, m, n, s, t, dp));
        if (s.charAt(i) == t.charAt(j))
            go = Math.max(1 + solve(i + 1, j + 1, m, n, s, t, dp), go);
        return dp[i][j] = go;
    }

}
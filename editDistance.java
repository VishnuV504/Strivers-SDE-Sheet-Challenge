import java.util.*;

public class Solution {

    public static int editDistance(String str1, String str2) {
        // Your code goes here
        int dp[][] = new int[1001][1001];
        for (int i = 0; i < 1001; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, 0, str1, str2, dp);
    }

    public static int solve(int i, int j, String word1, String word2, int dp[][]) {
        if (j >= word2.length())
            return word1.length() - i;
        if (i >= word1.length())
            return word2.length() - j;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = solve(i + 1, j + 1, word1, word2, dp);
        return dp[i][j] = 1 + Math.min(solve(i + 1, j, word1, word2, dp),
                Math.min(solve(i + 1, j + 1, word1, word2, dp), solve(i, j + 1, word1, word2, dp)));
    }
}
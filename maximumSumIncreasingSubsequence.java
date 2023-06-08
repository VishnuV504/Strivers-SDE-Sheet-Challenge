import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        int dp[][] = new int[n + 1][n + 2];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, rack, n, dp, -1);
    }

    public static int solve(int curr, ArrayList<Integer> arr, int n, int dp[][], int prev) {
        if (curr >= n)
            return 0;
        if (dp[curr][prev + 1] != -1)
            return dp[curr][prev + 1];
        int go = solve(curr + 1, arr, n, dp, prev);
        if (prev == -1 || arr.get(curr) > arr.get(prev))
            go = Math.max(go, arr.get(curr) + solve(curr + 1, arr, n, dp, curr));
        return dp[curr][prev + 1] = go;
    }
}
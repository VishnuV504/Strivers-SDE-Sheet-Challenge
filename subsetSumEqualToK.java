import java.util.*;
import java.io.*;

public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        Boolean dp[][] = new Boolean[n + 1][k + 1];
        return solve(0, k, arr, dp);
    }

    public static boolean solve(int curr, int k, int arr[], Boolean dp[][]) {
        if (curr >= arr.length)
            return k == 0;
        if (k < 0)
            return false;
        if (dp[curr][k] != null)
            return dp[curr][k];
        return dp[curr][k] = solve(curr + 1, k, arr, dp) || solve(curr + 1, k - arr[curr], arr, dp);
    }
}

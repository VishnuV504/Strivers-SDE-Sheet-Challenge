
//import java.util.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static int findWays(int nums[], int tar) {
        // Write your code here..

        int dp[][] = new int[nums.length + 1][tar + 1];
        for (int i = 0; i <= nums.length; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, nums, tar, dp);
    }

    public static int solve(int curr, int arr[], int k, int dp[][]) {
        if (curr == arr.length) {
            if (k == 0)
                return 1;
            return 0;
        }
        if (k < 0)
            return 0;
        if (dp[curr][k] != -1)
            return dp[curr][k];
        return dp[curr][k] = solve(curr + 1, arr, k, dp) + solve(curr + 1, arr, k - arr[curr], dp);
    }
}
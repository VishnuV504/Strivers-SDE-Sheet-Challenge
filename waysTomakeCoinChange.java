import java.util.*;

public class Solution {

    public static long countWaysToMakeChange(int coins[], int value) {
        // write your code here

        long dp[][] = new long[300][5002];
        for (int i = 0; i < 300; i++)
            Arrays.fill(dp[i], -1l);
        return totalWays(0, value, coins, dp);
    }

    private static long totalWays(int curr, int amount, int coins[], long dp[][]) {
        if (amount == 0)
            return 1l;
        if (curr == coins.length)
            return 0;
        if (dp[curr][amount] != -1)
            return dp[curr][amount];
        long pick = 0;
        if (coins[curr] <= amount)
            pick = totalWays(curr, amount - coins[curr], coins, dp);
        long notPick = totalWays(curr + 1, amount, coins, dp);
        dp[curr][amount] = pick + notPick;
        return dp[curr][amount];

    }

}
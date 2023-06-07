import java.util.*;
import java.io.*;

public class Solution {

    public static long maxSubarraySum(int[] arr, int n) {
        // write your code here
        long ans = Math.max(arr[0], 0);
        long maxSoFar = ans;
        for (int i = 1; i < n; i++) {
            maxSoFar = Math.max(maxSoFar + arr[i], arr[i]);
            ans = Math.max(ans, maxSoFar);
        }
        return ans;
    }

}

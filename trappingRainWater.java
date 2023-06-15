import java.util.*;
import java.io.*;

public class Solution {
    public static long getTrappedWater(long[] height, int n) {
        // Write your code here.
        long maxL = 0;
        long maxR = 0;
        long ngl[] = new long[n];
        long ngr[] = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            ngr[i] = maxR;
            maxR = Math.max(maxR, height[i]);
        }
        for (int i = 0; i < n; i++) {
            ngl[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }
        long sum = 0;
        for (int i = 1; i < n - 1; i++) {
            long min = Math.min(ngl[i], ngr[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}

import java.io.*;
import java.util.*;

public class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> ans = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.containsKey(arr[i]))
                hs.put(arr[i], hs.get(arr[i]) + 1);
            else
                hs.put(arr[i], 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int go = 0;
            if (hs.containsKey(arr[i])) {
                hs.put(arr[i], hs.get(arr[i]) - 1);
                if (hs.get(arr[i]) == 0)
                    hs.remove(arr[i]);
            }
            if (hs.containsKey(s - arr[i]))
                go = hs.get(s - arr[i]);
            while (go > 0) {
                int min = Math.min(arr[i], s - arr[i]);
                int max = Math.max(arr[i], s - arr[i]);
                int ok[] = { min, max };
                ans.add(ok);
                go--;
            }
        }
        Collections.sort(ans, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        return ans;
    }

}

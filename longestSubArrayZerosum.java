import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        // Write your code here.
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0, -1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (hs.containsKey(sum)) {
                max = Math.max(max, i - hs.get(sum));
            } else
                hs.put(sum, i);
        }
        return max;
    }
}
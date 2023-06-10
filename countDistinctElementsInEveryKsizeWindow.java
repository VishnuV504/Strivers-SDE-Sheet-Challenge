import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

        // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        int i = 0;
        int n = arr.size();
        while (i < k - 1) {
            if (hs.containsKey(arr.get(i)))
                hs.put(arr.get(i), hs.get(arr.get(i)) + 1);
            else
                hs.put(arr.get(i), 1);
            i++;
        }
        for (i = k - 1; i < n; i++) {
            if (i >= k && hs.containsKey(arr.get(i - k)))
                hs.put(arr.get(i - k), hs.get(arr.get(i - k)) - 1);
            if (i >= k && hs.get(arr.get(i - k)) == 0)
                hs.remove(arr.get(i - k));
            if (hs.containsKey(arr.get(i)))
                hs.put(arr.get(i), hs.get(arr.get(i)) + 1);
            else
                hs.put(arr.get(i), 1);
            ans.add(hs.size());
        }
        return ans;

    }
}

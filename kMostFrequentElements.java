import java.util.*;
import java.io.*;

public class Solution {

    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hs.containsKey(arr[i]))
                hs.put(arr[i], hs.get(arr[i]) + 1);
            else
                hs.put(arr[i], 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Integer key : hs.keySet()) {
            pq.add(new Pair(key, hs.get(key)));
        }
        int ans[] = new int[k];
        int go = 0;
        while (!pq.isEmpty()) {
            ans[go++] = pq.peek().curr;
            pq.remove();
            if (go >= k)
                break;
        }
        return ans;

    }

}

class Pair {
    int curr;
    int freq;

    Pair(int curr, int freq) {
        this.curr = curr;
        this.freq = freq;
    }
}

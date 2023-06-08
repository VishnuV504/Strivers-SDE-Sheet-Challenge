import java.util.*;
import java.io.*;

public class Solution {

    static int kthLargest(ArrayList<Integer> arr, int size, int K) {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            if (pq.size() < K)
                pq.add(arr.get(i));
            else if (arr.get(i) > pq.peek()) {
                pq.remove();
                pq.add(arr.get(i));
            }
        }
        return pq.peek();
    }
}

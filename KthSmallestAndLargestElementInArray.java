import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        // Write your code here
        ArrayList<Integer> li = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            if (minHeap.size() < k)
                minHeap.add(num);
            else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
            if (maxHeap.size() < k)
                maxHeap.add(num);
            else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(num);
            }
        }
        li.add(maxHeap.peek());
        li.add(minHeap.peek());
        return li;
    }
}

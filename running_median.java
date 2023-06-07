
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void findMedian(int arr[]) {

        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                ans[i] = minHeap.peek();
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
                ans[i] = (minHeap.peek() + maxHeap.peek()) / 2;
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(ans[i] + " ");
    }

}
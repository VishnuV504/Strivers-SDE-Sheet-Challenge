import java.util.*;
import java.io.*;

public class Kthlargest {
    int k;
    int nums[];
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    Kthlargest(int k, int[] nums) {
        // Write your code here.
        this.k = k;
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k)
                pq.add(nums[i]);
            else if (nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
    }

    void add(int num) {
        // Write your code here.
        if (pq.size() < k)
            pq.add(num);
        else if (num > pq.peek()) {
            pq.remove();
            pq.add(num);
        }
    }

    int getKthLargest() {
        // Write your code here.
        return pq.peek();
    }
}

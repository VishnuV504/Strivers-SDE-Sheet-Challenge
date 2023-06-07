import java.util.*;
public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>((a,b)->b-a);
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(minHeap.size()==maxHeap.size()){
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                ans[i]=minHeap.peek();
            }
            else{
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
                ans[i]=(minHeap.peek()+maxHeap.peek())/2;
            }
        }
        return ans;
    }
}

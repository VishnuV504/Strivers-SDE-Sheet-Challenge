import java.util.*;

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        // Write your code here
        int n = start.size();
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start.get(i);
            arr[i][1] = end.get(i);
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int count = 1;
        int en = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= en) {
                en = Math.max(en, arr[i][1]);
                count++;
            }
        }
        return count;
    }
}
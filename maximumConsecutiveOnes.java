import java.util.ArrayList;

public class Solution {
    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int count1 = 0;
        int j = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            while (arr.get(i) == 0 && count1 == k) {
                if (arr.get(j) == 0)
                    count1--;
                j++;
            }
            if (arr.get(i) == 0)
                count1++;
            maxLength = Math.max(i - j + 1, maxLength);
        }
        return maxLength;
    }
}
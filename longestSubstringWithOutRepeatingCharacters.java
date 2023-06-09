import java.util.*;
import java.io.*;

public class Solution {
    public static int uniqueSubstrings(String input) {
        // write your code here
        int freq[] = new int[26];
        int n = input.length();
        int j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = input.charAt(i) - 'a';
            while (freq[c] > 0) {
                int go = input.charAt(j) - 'a';
                freq[go]--;
                j++;
            }
            freq[c]++;
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}

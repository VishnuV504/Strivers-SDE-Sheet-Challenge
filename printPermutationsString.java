import java.util.*;
import java.io.*;

public class Solution {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        solve(s, new StringBuilder(), ans, new boolean[s.length()]);
        return ans;
    }

    public static void solve(String s, StringBuilder sb, List<String> ans, boolean visited[]) {
        if (sb.length() >= s.length()) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            sb.append(s.charAt(i));
            solve(s, sb, ans, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
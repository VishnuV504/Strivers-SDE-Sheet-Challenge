import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        solve(0, new ArrayList<>(), ans, new boolean[n], arr);
        return ans;
    }

    public static void solve(int curr, ArrayList<Integer> li, ArrayList<ArrayList<Integer>> ans, boolean visited[],
            int arr[]) {
        ans.add(new ArrayList<>(li));
        for (int i = curr; i < arr.length; i++) {
            if (visited[i])
                continue;
            if (i == 0 || arr[i] != arr[i - 1] || visited[i - 1]) {
                visited[i] = true;
                li.add(arr[i]);
                solve(i + 1, li, ans, visited, arr);
                li.remove(li.size() - 1);
                visited[i] = false;
            }
        }
    }

}
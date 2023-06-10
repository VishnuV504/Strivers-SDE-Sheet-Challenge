import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        // WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(0, arr, ans, new ArrayList<Integer>());
        return ans;
    }

    public static void solve(int curr, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> li) {
        if (curr >= arr.size()) {
            ans.add(new ArrayList<>(li));
            return;
        }
        solve(curr + 1, arr, ans, li);
        li.add(arr.get(curr));
        solve(curr + 1, arr, ans, li);
        li.remove(li.size() - 1);
        return;
    }
}

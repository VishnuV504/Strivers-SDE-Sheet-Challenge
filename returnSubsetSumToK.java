import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(0, arr, k, ans, new ArrayList<Integer>());
        Collections.sort(ans, (a, b) -> a.get(0) - b.get(0));
        return ans;
    }

    public static void solve(int curr, ArrayList<Integer> arr, int k, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> go) {
        if (curr >= arr.size()) {
            if (k == 0 && go.size() > 0) {
                ArrayList<Integer> li = new ArrayList<>(go);
                // Collections.sort(li);
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        solve(curr + 1, arr, k, ans, go);
        go.add(arr.get(curr));
        solve(curr + 1, arr, k - arr.get(curr), ans, go);
        go.remove(go.size() - 1);
        return;

    }
}